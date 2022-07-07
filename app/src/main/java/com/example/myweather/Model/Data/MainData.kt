package com.example.myweather.Model.Data

data class MainData(
    val fact: Fact,
    val forecasts: List<Forecast>,
    val geo_object: GeoObject,
    val info: Info,
    val now: Int,
    val now_dt: String,
    val yesterday: Yesterday
)