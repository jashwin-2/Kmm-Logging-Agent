package com.example.kmmapplication.model

import com.example.kmmapplication.Utils

data class LogMessage(
    val logLevel: String,
    val logMessage: String,
    private val time: String = Utils.getCurrentTime()
) {
    companion object {
        const val INFO = "Info"
        const val WARN = "Warning"
        const val ERROR = "Error"
    }
}