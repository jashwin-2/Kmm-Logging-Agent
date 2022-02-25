package com.example.kmmapplication

import android.content.res.AssetManager


expect object Utils {

    fun detectMimeType(fileName: String): String?

    fun loadContent(fileName: String?, assetManager: AssetManager): ByteArray?


    fun getCurrentTime(): String

}