package com.example.myweather.Model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myweather.Model.Data.MainData

class MainViewModel : ViewModel(){
    val liveDataCurrent = MutableLiveData<MainData>()
    val liveDataList = MutableLiveData<List<MainData>>()
}