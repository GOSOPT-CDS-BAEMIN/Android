package com.sopt.baemin.data.service

import com.sopt.baemin.data.model.response.FoodResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FoodListReviewService {
    @GET("/1")
    fun getFoodListReview(
    ):Response<FoodResponse>
}