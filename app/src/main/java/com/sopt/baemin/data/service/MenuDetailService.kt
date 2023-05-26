package com.sopt.baemin.data.service

import com.sopt.baemin.data.model.response.ResponseGetMenuDetailDto
import retrofit2.Call
import retrofit2.http.GET

interface MenuDetailService {
    @GET("food/1")
    fun getMenuDetail(
    ): Call<ResponseGetMenuDetailDto>
}