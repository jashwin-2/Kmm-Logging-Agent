package com.example.kmmapplication

interface WebSocketCallback {
    fun onError(ex: Exception)
    fun onMessageReceived(message: String?)
}