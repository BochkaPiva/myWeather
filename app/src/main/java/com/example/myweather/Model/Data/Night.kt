package com.example.myweather.Model.Data

data class Night(
    val _source: String,
    val cloudness: Double,
    val condition: String,
    val daytime: String,
    val feels_like: Int,
    val humidity: Int,
    val icon: String,
    val polar: Boolean,
    val prec_mm: Int,
    val prec_period: Int,
    val prec_prob: Int,
    val prec_strength: Int,
    val prec_type: Int,
    val pressure_mm: Int,
    val pressure_pa: Int,
    val temp_avg: Int,
    val temp_max: Int,
    val temp_min: Int,
    val temp_water: Int,
    val uv_index: Int,
    val wind_dir: String,
    val wind_gust: Double,
    val wind_speed: Double
)