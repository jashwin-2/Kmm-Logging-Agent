package com.example.kmmapplication

import com.example.kmmapplication.model.JsonData

expect fun log(string: String) : Unit
expect fun JsonData.ToJson() : String