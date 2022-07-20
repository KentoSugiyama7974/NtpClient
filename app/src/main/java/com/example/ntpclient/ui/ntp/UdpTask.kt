package com.example.ntpclient.ui.ntp

import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetSocketAddress
import java.net.SocketException

class UdpTask {
    private lateinit var packet: DatagramPacket
    private var socket: DatagramSocket = DatagramSocket()
    private lateinit var inetSocketAddress: InetSocketAddress

    fun setIpAddress(ipAddress:String){
        inetSocketAddress = InetSocketAddress(ipAddress, 60002)
    }

    fun sendData(msg: String){
        try {
            packet = DatagramPacket(msg.toByteArray(), msg.toByteArray().size, inetSocketAddress)
            socket.send(packet)
        } catch (e: SocketException){
            e.printStackTrace()
        }
    }

    fun receiveData(): String{
        val msg = ByteArray(1024)
        packet = DatagramPacket(msg, msg.size)
        socket.receive(packet)
        return String(msg, charset("UTF-8"))
    }
}