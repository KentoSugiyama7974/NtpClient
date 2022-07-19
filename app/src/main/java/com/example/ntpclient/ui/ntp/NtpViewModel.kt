package com.example.ntpclient.ui.ntp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NtpViewModel : ViewModel() {

    private val _offSet = MutableLiveData<Double>()
    val offSet: LiveData<Double> = _offSet

}