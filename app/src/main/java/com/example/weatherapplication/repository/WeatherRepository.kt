package com.example.weatherapplication.repository

import com.example.weatherapplication.api.ApiService
import com.example.weatherapplication.di.RetrofitInstance
import com.example.weatherapplication.model.Weather
import retrofit2.awaitResponse
import javax.inject.Inject

class WeatherRepository {
    companion object {
        suspend fun getWeather(city: String): Weather? {

            return RetrofitInstance.api.getWeather(city).awaitResponse().body()
        }
    }
}