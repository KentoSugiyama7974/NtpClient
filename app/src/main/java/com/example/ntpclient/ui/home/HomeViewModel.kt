package com.example.ntpclient.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val _ipAddress = MutableLiveData<String>()
    val ipAddress: LiveData<String> = _ipAddress

    init{
        _ipAddress.value = "192.168.11."
    }
}