package com.sopt.baemin.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseGetReviewFilterFoodDto (
    val status: Long? = null,
    val success: Boolean? = null,
    val message: String? = null,
    val data: ReviewFilterFood? = null
)

@Serializable
data class ReviewFilterFood (
    val storeInfo: StoreInfo? = null,
    val foods: List<Food>? = null
)

@Serializable
data class StoreInfo (
    @SerialName("storeId")
    val storeID: Long? = null,
    @SerialName("storeTypeId")
    val storeTypeID: Long? = null,
    val storeType: String? = null,
    val storeName: String? = null,
    val deliveryTime: String? = null,
    val description: String? = null,
    val minOrderPrice: Long? = null,
    val deliveryFee: Long? = null,
    val rate: Double? = null,
    val storeImages: List<String>? = null,
    val couponExist: Boolean? = null,
    val new: Boolean? = null
)