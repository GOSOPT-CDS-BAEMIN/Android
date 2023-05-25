package com.sopt.baemin.data.service

import com.sopt.baemin.data.model.response.ResponseGetCartListDto
import retrofit2.http.GET

interface CartService {
    @GET("cart")
    suspend fun getCartList() : ResponseGetCartListDto
}