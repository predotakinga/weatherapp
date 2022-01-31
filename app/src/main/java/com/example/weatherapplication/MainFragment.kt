package com.example.weatherapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapplication.ViewModel.weatherAppViewModel
import com.example.weatherapplication.databinding.ActivityMainBinding
import com.example.weatherapplication.databinding.FragmentMainBinding
import android.view.View as View

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel : weatherAppViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var cityName = viewModel.city
        binding.button.setOnClickListener { viewModel.getWeather(view.findViewById<SearchView>(R.id.searchView).getQuery().toString())
            cityName= view.findViewById<SearchView>(R.id.searchView).getQuery().toString() }
        viewModel.weatherResp.observe(this,{
                weather->
            binding.apply{
                tvCityName.text = cityName
                tvTemperature.text=weather.temperature
                tvDescription.text = weather.description
                tvWind.text = weather.wind
                val forecast1 = weather.forecast[0]
                val forecast2 = weather.forecast[1]
                val forecast3 = weather.forecast[2]
                tvForecast1.text = "${forecast1.temperature}/${forecast1.wind}"
                tvForecast2.text = "${forecast2.temperature}/${forecast2.wind}"
                tvForecast3.text = "${forecast3.temperature}/${forecast3.wind}"

            }
        })
    }}









