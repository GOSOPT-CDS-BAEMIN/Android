package com.sopt.baemin.data.service

import com.sopt.baemin.data.model.request.RequestPostCartItemDto
import com.sopt.baemin.data.model.response.BaseResponse
import com.sopt.baemin.data.model.response.ResponseGetStoreListDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CartService {
    @POST("cart/add")
    suspend fun postCartItem(
        @Body request: RequestPostCartItemDto
    ): BaseResponse<Any>

    @GET("cart")
    suspend fun getStoreList(): ResponseGetStoreListDto
}