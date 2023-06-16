package com.example.managerapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SampleViewModel:ViewModel() {

    val username=MutableLiveData<String>()

}