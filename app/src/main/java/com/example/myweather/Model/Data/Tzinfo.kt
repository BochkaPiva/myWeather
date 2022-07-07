package com.example.myweather.Model.Data

data class Tzinfo(
    val abbr: String,
    val dst: Boolean,
    val name: String,
    val offset: Int
)