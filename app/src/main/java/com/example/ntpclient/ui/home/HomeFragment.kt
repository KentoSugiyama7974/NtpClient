package com.example.ntpclient.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.ntpclient.R
import com.example.ntpclient.databinding.FragmentHomeBinding
import com.example.ntpclient.util.EventObserver
import java.util.*

class HomeFragment : Fragment() {

    private val viewModel by lazy { ViewModelProvider(this).get(HomeViewModel::class.java)}
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false).apply{
            viewmodel = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.startButtonEvent.observe(this.viewLifecycleOwner, EventObserver{
            if (it=="success"){
                val action = HomeFragmentDirections.actionHomeFragmentToNtpFragment(viewModel.ipAddress.value?:"192.168.11.2")
                view.findNavController().navigate(action)
            }
            if (it=="failure"){
                Toast.makeText(this.context, "正しいIPを入力してください", Toast.LENGTH_SHORT).show()
            }

        })
    }

}