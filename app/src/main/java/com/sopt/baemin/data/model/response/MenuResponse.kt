package com.sopt.baemin.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class MenuResponse(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: StoreData
)

@Serializable
data class StoreData(
    val storeInfo: StoreInfomation,
    val foods: List<Foods>
)

@Serializable
data class StoreInfomation(
    val storeId: Int,
    val storeTypeId: Int,
    val storeType: String,
    val storeName: String,
    val deliveryTime: String,
    val description: String,
    val minOrderPrice: Int,
    val deliveryFee: Int,
    val rate: Double,
    val firstImageUrl: String,
    val secondImageUrl: String,
    val thirdImageUrl: String,
    val couponExist: Boolean,
    val new: Boolean
)

@Serializable
data class Foods(
    val foodId: Int,
    val foodName: String,
    val price: Int,
    val foodDescription: String,
    val foodImageUrl: String,
    val best: Boolean
)
