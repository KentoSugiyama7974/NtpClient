package com.example.ntpclient.ui.ntp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.ntpclient.R
import com.example.ntpclient.databinding.FragmentHomeBinding
import com.example.ntpclient.databinding.FragmentNtpBinding

class NtpFragment : Fragment() {

    private val viewModel by lazy { ViewModelProvider(this).get(NtpViewModel::class.java)}
    private lateinit var binding: FragmentNtpBinding
    private val args: NtpFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNtpBinding.inflate(inflater, container, false).apply{
            viewmodel = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }
}