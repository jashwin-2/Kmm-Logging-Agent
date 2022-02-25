package com.example.kmmapplication

expect class Assets
expect class RequestHandler(platformSocket: PlatformSocket, assets: Assets) {
fun handle() : Unit
fun close()
}