package com.sopt.baemin.presentation.restaurant_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.sopt.baemin.data.api.ApiClient.ServicePool.baeminService
import com.sopt.baemin.data.model.response.Datum
import com.sopt.baemin.data.model.response.RestaurantListResponse
import com.sopt.baemin.data.service.BaeminService
import com.sopt.baemin.databinding.FragmentPage01Binding
import com.sopt.baemin.presentation.view.Page01Adapter
import kotlinx.coroutines.launch

class Page01Fragment : Fragment() {
    //private val page01ViewModel: Page01ViewModel by viewModels()
    private lateinit var page01Adapter: Page01Adapter
    private var _binding: FragmentPage01Binding? = null
    private val binding: FragmentPage01Binding
        get() = requireNotNull(_binding) { "not null" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPage01Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            val type = 3
            val response = baeminService.getRestaurntList(type)
            if(response.isSuccessful){
                val storeList: List<Datum?>? = response.body()?.data
                initAdapter()
                page01Adapter.submitList(storeList)
            }else{
                Log.d("error",response.errorBody().toString())
            }
        }
    }

    fun initAdapter()
    {
        page01Adapter = Page01Adapter()
        binding.viewpagerPage01.adapter = page01Adapter
    }
}