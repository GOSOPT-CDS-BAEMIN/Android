package com.sopt.baemin.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReviewResponse(
    @SerialName("status")
    val status: Int,
    @SerialName("success")
    val success: Boolean,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<Review>
)

@Serializable
data class Review(
    @SerialName("nickname")
    val nickname: String,
    @SerialName("reviewRate")
    val reviewRate: Double,
    @SerialName("reviewImageUrl")
    val reviewImageUrl: String,
    @SerialName("content")
    val content: String
)
