package com.example.weatherapplication.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherapplication.model.Weather
import com.example.weatherapplication.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class weatherAppViewModel(): ViewModel()

{
    private val _weatherResp:MutableLiveData<Weather> = MutableLiveData()
    val weatherResp:LiveData<Weather>

        get()
        { return _weatherResp}
    var city = "Los Angeles"
    init{
        getWeather(city)
    }
    fun getWeather(city: String)
    {
        viewModelScope.launch {
            val weather = WeatherRepository.getWeather(city)
            _weatherResp.value = weather!!
        }

    }

}
