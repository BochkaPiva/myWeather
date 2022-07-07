package com.example.myweather.fragments

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.example.myweather.adapters.ViewPagerAdapter
import com.example.myweather.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.core.content.ContextCompat.getSystemService

class MainFragment : Fragment() {
    private lateinit var pLauncher: ActivityResultLauncher<String>
    private lateinit var binding : FragmentMainBinding
    private val activityList = listOf(
        HourlyWeatherFragment.newInstance(),
        DailyWeatherFragment.newInstance()
    )
    private val tList = listOf(
        "Hourly" ,
        "Daily"
        )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()
        init()
    }

    private fun init() = with(binding){
        val adapter = ViewPagerAdapter(activity as FragmentActivity, activityList)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager){
            tab, position -> tab.text = tList[position].toString()
        }.attach()
    }

// Лаунчер call-back, показывающий статус разрешения
    private fun pListener() {
        pLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){
            Toast.makeText(activity, "permission is $it", Toast.LENGTH_LONG).show()
        }
    }
//Проверка наличия разрешения на использование геолокации
    private fun checkPermission(){
        if(ContextCompat.checkSelfPermission(activity as AppCompatActivity, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            pListener()
            pLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    private fun getLocation(){
        val locationManager: LocationManager =
            activity?.applicationContext?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER, 10000,
            500f, this)
    }

//    override fun onLocationChanged(location: Location) {
//        binding.zalupa.text = location.latitude.toString()
//    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}

private fun LocationManager.requestLocationUpdates(
    gpsProvider: String,
    i: Int,
    fl: Float,
    mainFragment: MainFragment
){}
