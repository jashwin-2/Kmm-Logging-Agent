package com.example.kmmapplication


expect object NetworkUtils {
    fun getAddress(port: Int): MutableList<String>
}