package com.sopt.baemin.data.model.response


import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class FoodResponse (
    val status: Long? = null,
    val success: Boolean? = null,
    val message: String? = null,
    val data: Data? = null
)

@Serializable
data class Data (
    val storeInfo: StoreInfo? = null,
    val foods: List<Food>? = null
)

@Serializable
data class Food (
    @SerialName("foodId")
    val foodID: Long? = null,

    val foodName: String? = null,
    val price: Long? = null,
    val foodDescription: String? = null,

    @SerialName("foodImageUrl")
    val foodImageURL: String? = null,

    val best: Boolean? = null
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