package com.sopt.baemin.data.service

import com.sopt.baemin.data.model.response.ReviewResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ReviewService {
    @GET("review/{storeId}")
    fun getReview(
        @Path("storeId") storeId: Int
    ): Call<ReviewResponse>
}
