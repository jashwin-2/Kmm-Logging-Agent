package com.example.logging_agent

interface WebSocketCallback {
    fun onError(ex: Exception)
    fun onMessageReceived(message: String?)
}