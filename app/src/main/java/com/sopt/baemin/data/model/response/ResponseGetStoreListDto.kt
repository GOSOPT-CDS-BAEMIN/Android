package com.sopt.baemin.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseGetStoreListDto(
    val status: Int,
    val success: Boolean,
    val message: String,
    @SerialName("data")
    val stores: List<Store>
)

@Serializable
data class Store(
    val storeId: Int,
    val storeName: String,
    val deliveryFee: Int,
    val minOrderPrice: Int,
    val foods: List<Food>
)

@Serializable
data class Food(
    val foodId: Int,
    val foodName: String,
    val price: Int,
    val foodImageUrl: String,
    val foodDescription: String,
    val foodCount: Int
)