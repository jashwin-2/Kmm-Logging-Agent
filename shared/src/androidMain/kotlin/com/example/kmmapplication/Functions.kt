package com.example.kmmapplication

import android.util.Log
import com.example.kmmapplication.model.JsonData
import com.google.gson.Gson
import org.json.JSONObject

actual fun log(string: String) {
    Log.d("Server", string)
}
actual fun JsonData.ToJson() : String{
    return if (json is JSONObject) {
        val obj = JSONObject()
        obj.put("type", type)
        obj.put("id", id)
        obj.put("json", json)
        obj.toString()
    } else {
        val gson = Gson()
        gson.toJson(this)
    }
}