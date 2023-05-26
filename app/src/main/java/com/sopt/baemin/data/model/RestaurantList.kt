package com.sopt.baemin.data.model

import com.sopt.baemin.data.model.response.RestaurantListResponse

data class RestaurantList(
    val status: Long,
    val success: Boolean,
    val message: String,
    val data: List<RestaurantListResponse>,
)