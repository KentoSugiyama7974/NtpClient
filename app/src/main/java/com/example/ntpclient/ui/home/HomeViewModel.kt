package com.example.ntpclient.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ntpclient.util.Event

class HomeViewModel : ViewModel() {
    private val _startButtonEvent = MutableLiveData<Event<String>>(Event(""))
    val startButtonEvent: LiveData<Event<String>> = _startButtonEvent

    var ipAddress = MutableLiveData<String>("192.168.11.")

    fun onStartButtonClicked(){
        val regex = Regex(pattern="""\d{1,3}.\d{1,3}.\d{1,3}.\d{1,3}""")
        if (regex.matches(ipAddress.value?:"")){
            _startButtonEvent.value = Event("success")
        }else{
            _startButtonEvent.value = Event("failure")
        }

    }
}