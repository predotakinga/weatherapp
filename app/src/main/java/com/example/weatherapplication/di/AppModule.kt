package com.example.weatherapplication.di

import com.example.weatherapplication.api.ApiService

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val BASE_URL="https://goweather.herokuapp.com/"
object RetrofitInstance {

    private val retrofit by lazy{

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://goweather.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}

