package com.example.logging_agent


expect object NetworkUtils {
    fun getAddress(port: Int): MutableList<String>
}