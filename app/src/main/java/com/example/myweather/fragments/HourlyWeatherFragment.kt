package com.example.myweather.fragments

import android.media.MediaCodec
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myweather.R
import com.example.myweather.adapters.WeatherAdapter
import com.example.myweather.databinding.FragmentHourlyWeatherBinding

class HourlyWeatherFragment : Fragment() {
    private lateinit var binding: FragmentHourlyWeatherBinding
    lateinit var adapter: WeatherAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHourlyWeatherBinding.inflate(inflater, container,false)
        return binding.root
        initRcView()
    }

    companion object {
        @JvmStatic
        fun newInstance() = HourlyWeatherFragment()
    }

    private fun initRcView() = with(R.layout.fragment_hourly_weather){
        adapter = WeatherAdapter()

    }
}