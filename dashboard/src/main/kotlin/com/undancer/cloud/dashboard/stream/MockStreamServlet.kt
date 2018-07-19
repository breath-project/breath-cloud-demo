package com.undancer.cloud.dashboard.stream


import org.apache.commons.io.IOUtils
import org.slf4j.LoggerFactory
import java.io.IOException
import java.nio.charset.Charset
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Simulate an event stream URL by retrieving pre-canned data instead of going to live servers.
 */
class MockStreamServlet : HttpServlet() {

    val logger = LoggerFactory.getLogger(MockStreamServlet::class.java)

    /**
     * @see javax.servlet.http.HttpServlet.doGet
     */
    @Throws(ServletException::class, IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        var filename: String? = request.getParameter("file")
        if (filename == null) {
            // default to using hystrix.stream
            filename = "hystrix.stream"
        } else {
            // strip any .. / characters to avoid security problems
            filename = filename.replace("\\.\\.".toRegex(), "")
            filename = filename.replace("/".toRegex(), "")
        }
        var delay = 500
        val delayArg = request.getParameter("delay")
        if (delayArg != null) {
            delay = Integer.parseInt(delayArg)
        }

        var batch = 1
        val batchArg = request.getParameter("batch")
        if (batchArg != null) {
            batch = Integer.parseInt(batchArg)
        }

        val data = getFileFromPackage(filename)
        val lines = data.split("\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

        response.contentType = "text/event-stream"
        response.characterEncoding = "UTF-8"

        var batchCount = 0
        // loop forever unless the user closes the connection
        while (true) {
            lines.forEach { line ->
                var s = line.trim { it <= ' ' }
                if (s.isNotEmpty()) {
                    try {
                        response.writer.println(s)
                        response.writer.println("") // a newline is needed after each line for the events to trigger
                        response.writer.flush()
                        batchCount++
                    } catch (e: Exception) {
                        logger.warn("Exception writing mock data to output.", e)
                        // most likely the user closed the connection
                        return
                    }

                    if (batchCount == batch) {
                        // we insert the delay whenever we finish a batch
                        try {
                            // simulate the delays we get from the real feed
                            Thread.sleep(delay.toLong())
                        } catch (e: InterruptedException) {
                            // ignore
                        }

                        // reset
                        batchCount = 0
                    }
                }
            }
        }
    }

    private fun getFileFromPackage(filename: String): String {
        try {
            val file = "/" + this.javaClass.getPackage().name.replace('.', '/') + "/" + filename
            return this.javaClass.getResourceAsStream(file)
                    .bufferedReader(Charset.forName("UTF-8"))
                    .use { i -> IOUtils.toString(i) }
        } catch (e: Exception) {
            throw RuntimeException("Could not find file: $filename", e)
        }

    }

}