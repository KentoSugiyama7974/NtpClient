package com.example.ntpclient.ui.ntp

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.concurrent.timer

class NtpViewModel : ViewModel() {
    private var unixTask: UnixTask = UnixTask()
    private var udpTask: UdpTask = UdpTask()

    var ip = MutableLiveData<String>("")
    var androidTime = MutableLiveData<String>("")
    var adjustTime = MutableLiveData<String>("")


    fun start(ipAddress:String){
        ip.value = ipAddress
        udpTask.setIpAddress(ipAddress)
        val handler = Handler()
        timer(name="now", period = 10){
            handler.post{
                androidTime.value = unixTask.getDate()
                adjustTime.value = unixTask.getAdjustDate()
            }
        }
    }

    fun onAdjustButtonClicked(){
        Thread(Ntp()).start()
    }

    inner class Ntp: Runnable {
        override fun run() {
            val now = unixTask.getUnix()
            udpTask.sendData(now)
            val msg = udpTask.receiveData()
            val t3 = unixTask.getUnix().toDouble()
            val ary = msg.split(',')
            val t1_t0 = ary[0].toDouble()
            val t2 = ary[1].toDouble()

            var offSet = ((t1_t0)-(t3-t2))/2.toDouble()
            unixTask.setOffSet(offSet)
        }
    }

}