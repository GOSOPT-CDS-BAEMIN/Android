package com.sopt.baemin.data.service

import com.sopt.baemin.data.model.response.MenuDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MenuDetailService {
    @GET("food/1")
    fun getMenuDetail(
    ): Call<MenuDetailResponse>
}