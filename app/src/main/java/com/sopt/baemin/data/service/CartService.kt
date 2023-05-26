package com.sopt.baemin.data.service

import com.sopt.baemin.data.model.response.ResponseGetStoreListDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CartService {
    @GET("cart/{userId}")
    suspend fun getStoreList(
        @Path("userId") userId: Int
    ): ResponseGetStoreListDto
}