package com.example.weatherapplication.api

import com.example.weatherapplication.model.Weather
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("weather/{city}")
     fun getWeather(@Path("city") city: String): Call<Weather>
}