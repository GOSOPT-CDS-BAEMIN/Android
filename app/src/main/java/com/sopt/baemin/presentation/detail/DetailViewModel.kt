package com.sopt.baemin.presentation.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.baemin.data.api.ApiClient
import com.sopt.baemin.data.api.MenuService
import com.sopt.baemin.data.api.ReviewService
import com.sopt.baemin.data.model.response.MenuResponse
import com.sopt.baemin.data.model.response.ReviewResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel : ViewModel() {
    private val reviewService = ApiClient.getRetrofit().create(ReviewService::class.java)
    private val menuService = ApiClient.getRetrofit().create(MenuService::class.java)

    private val _reviewInfo = MutableLiveData<ReviewResponse>()
    val reviewInfo: LiveData<ReviewResponse>
        get() = _reviewInfo

    private val _menuInfo = MutableLiveData<MenuResponse>()
    val menuInfo: LiveData<MenuResponse>
        get() = _menuInfo

    fun getReview(storeId: Int) {
        reviewService.getReview(storeId).enqueue(object : Callback<ReviewResponse> {
            override fun onResponse(
                call: Call<ReviewResponse>,
                response: Response<ReviewResponse>
            ) {
                if (response.isSuccessful) {
                    Log.d("서버 통신 성공", response.message())
                    _reviewInfo.value = response.body()
                }
            }

            override fun onFailure(call: Call<ReviewResponse>, t: Throwable) {
                Log.d("서버 통신 실패", t.toString())
            }
        })
    }

    fun getMenu(storeId: Int) {
        menuService.getMenu(storeId).enqueue(object : Callback<MenuResponse> {
            override fun onResponse(
                call: Call<MenuResponse>,
                response: Response<MenuResponse>
            ) {
                if (response.isSuccessful) {
                    Log.d("서버 통신 성공", response.message())
                    _menuInfo.value = response.body()
                }
            }

            override fun onFailure(call: Call<MenuResponse>, t: Throwable) {
                Log.d("서버 통신 실패", t.toString())
            }
        })
    }
}
