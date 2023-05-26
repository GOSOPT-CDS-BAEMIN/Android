package com.sopt.baemin.presentation.store_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sopt.baemin.databinding.FragmentPage02Binding

class Page02Fragment : Fragment() {

    lateinit var binding: FragmentPage02Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPage02Binding.inflate(inflater, container, false)
        return binding.root
    }
}