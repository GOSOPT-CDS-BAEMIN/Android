package com.sopt.baemin.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuResponse(
    @SerialName("status")
    val status: Int,
    @SerialName("success")
    val success: Boolean,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: StoreData
)

@Serializable
data class StoreData(
    @SerialName("storeInfo")
    val storeInfo: StoreInfo,
    @SerialName("foods")
    val foods: List<Foods>
)

@Serializable
data class StoreInfo(
    @SerialName("storeId")
    val storeId: Int,
    @SerialName("storeTypeId")
    val storeTypeId: Int,
    @SerialName("storeType")
    val storeType: String,
    @SerialName("storeName")
    val storeName: String,
    @SerialName("deliveryTime")
    val deliveryTime: String,
    @SerialName("description")
    val description: String,
    @SerialName("minOrderPrice")
    val minOrderPrice: Int,
    @SerialName("deliveryFee")
    val deliveryFee: Int,
    @SerialName("rate")
    val rate: Double,
    @SerialName("storeImages")
    val storeImages: List<String>,
    @SerialName("couponExist")
    val couponExist: Boolean,
    @SerialName("new")
    val new: Boolean
)

@Serializable
data class Foods(
    @SerialName("foodId")
    val foodId: Int,
    @SerialName("foodName")
    val foodName: String,
    @SerialName("price")
    val price: Int,
    @SerialName("foodDescription")
    val foodDescription: String,
    @SerialName("foodImageUrl")
    val foodImageUrl: String,
    @SerialName("best")
    val best: Boolean
)
