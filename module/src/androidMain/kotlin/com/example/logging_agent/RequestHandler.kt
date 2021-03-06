package com.example.logging_agent

import android.content.res.AssetManager
import android.text.TextUtils
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintStream
import java.net.ServerSocket
import java.util.*

actual class Server actual constructor(port : Int){
    private val serverSocket : ServerSocket = ServerSocket(port)
    actual fun accept(): PlatformSocket {
        return serverSocket.accept()
    }

    actual fun close() {
        serverSocket.close()
    }

}
actual typealias PlatformSocket = java.net.Socket
actual typealias Assets = AssetManager
actual class RequestHandler actual constructor(val platformSocket : PlatformSocket, var assets: AssetManager) {
  actual fun handle() {
        var reader: BufferedReader? = null
        var output: PrintStream? = null
        try {

            var route: String? = null
            val inp = platformSocket.getInputStream()
            val s = Scanner(inp, "UTF-8")
            val data: String = s.useDelimiter("\\r\\n\\r\\n").next()
            log(data)
            // Read HTTP headers and parse out the route.
            reader = BufferedReader(InputStreamReader(platformSocket.getInputStream()))
           var line: String
           while (!TextUtils.isEmpty(data.also { line = it })) {
               if (line.startsWith("GET /")) {
                   val start = line.indexOf('/') + 1
                   val end = line.indexOf(' ', start)
                   route = line.substring(start, end)
                   break
               }
           }
           output = PrintStream(platformSocket.getOutputStream())
            route?.let { log(it) }
           // Output stream that we send the response to
           if (route == null || route.isEmpty()) {
               route = "home.html"

           }
            val bytes: ByteArray = Utils.loadContent(route, assets)!!



           output.println("HTTP/1.0 200 OK")
           output.println("Content-Type: " + Utils.detectMimeType(route))
           output.println("Content-Length: " + bytes.size)
           output.println()
           output.write(bytes)
           output.flush()
       } finally {
           try {
               output?.close()
               reader?.close()
           } catch (e: Exception) {
               e.printStackTrace()
           }
       }


}

    actual fun close() {
        platformSocket.close()
    }
}


