package com.example.ntpclient.ui.ntp

import java.text.SimpleDateFormat
import java.util.*

class UnixTask {
    val sdf: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault())
    var offset: Double = 0.0

    fun getUnix(): String{
        return String.format("%10.3f", System.currentTimeMillis().toDouble() / 1000.toDouble())
    }

    fun getAdjustTime(): String{
        return (getUnix().toDouble()+offset).toString()
    }

    fun unixToDate(unix: String): String{
        val unix = (unix.toDouble()*1000).toLong()
        val date = Date(unix)
        return sdf.format(date)
    }

    fun setOffSet(sec: Double){
        offset = sec
    }

    fun getDate(): String{
        return unixToDate(getUnix())
    }

    fun getAdjustDate(): String{
        return unixToDate(getAdjustTime())
    }
}