package com.sopt.baemin.presentation.store_list

import android.os.Bundle
import android.view.View
import com.sopt.baemin.R
import com.sopt.baemin.data.api.ApiFactory.ServicePool.baeminService
import com.sopt.baemin.data.model.response.Datum
import com.sopt.baemin.data.model.response.RestaurantListResponse
import com.sopt.baemin.databinding.FragmentPage01Binding
import com.sopt.baemin.util.binding.BindingFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class Page01Fragment : BindingFragment<FragmentPage01Binding>(R.layout.fragment_page01) {
    private lateinit var page01Adapter: Page01Adapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        getStoreList()
    }

    private fun getStoreList() {
        baeminService.getRestaurntList(1)
            .enqueue(object : Callback<RestaurantListResponse> {
                override fun onResponse(
                    call: Call<RestaurantListResponse>,
                    response: Response<RestaurantListResponse>
                ) {
                    if (response.isSuccessful) {
                        val storeList: List<Datum?>? = response.body()?.data
                        page01Adapter.submitList(storeList)
                    } else {
                        Timber.e("${response.code()} ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<RestaurantListResponse>, t: Throwable) {
                    Timber.e("${t.message}")
                }

            })
    }

    private fun initAdapter() {
        page01Adapter = Page01Adapter()
        binding.viewpagerPage01.adapter = page01Adapter
    }
}