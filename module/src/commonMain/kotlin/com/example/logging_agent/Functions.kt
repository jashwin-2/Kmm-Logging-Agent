package com.example.logging_agent

import com.example.logging_agent.model.JsonData

expect fun log(string: String) : Unit
expect fun JsonData.ToJson() : String