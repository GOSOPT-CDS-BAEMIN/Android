package com.sopt.baemin.data.service

import com.sopt.baemin.data.model.response.ResponseGetReviewFilterFoodDto
import retrofit2.Response
import retrofit2.http.GET

interface FoodListReviewService {
    @GET("/1")
    fun getFoodListReview(
    ):Response<ResponseGetReviewFilterFoodDto>
}