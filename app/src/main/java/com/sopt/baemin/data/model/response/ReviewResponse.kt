package com.sopt.baemin.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class ReviewResponse(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<Review>
)

@Serializable
data class Review(
    val reviewId: Int,
    val nickname: String,
    val reviewRate: Double,
    val reviewImageUrl: String,
    val content: String
)
