package com.sopt.baemin.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class Food(
    val foodId: Int,
    val foodName: String,
    val price: Int,
    val foodImageUrl: String,
    val foodDescription: String,
    val foodCount: Int
)