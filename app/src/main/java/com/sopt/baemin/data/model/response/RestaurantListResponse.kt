package com.sopt.baemin.data.model.response


import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class RestaurantListResponse(
    val status: Long?,
    val success: Boolean?,
    val message: String?,
    val data: List<Datum>?
)

@Serializable
data class Datum(
    @SerialName("storeId")
    val storeID: Long?,
    @SerialName("storeTypeId")
    val storeTypeID: Long?,
    val storeType: StoreType?,
    val storeName: String?,
    val deliveryTime: String?,
    val description: String?,
    val minOrderPrice: Long?,
    val deliveryFee: Long?,
    val rate: Double?,
    val storeImages: List<StoreImage>?,
    val new: Boolean?,
    val couponExist: Boolean?
)

@Serializable
enum class StoreImage(val value: String) {
    @SerialName("url1")
    Url1("url1"),
    @SerialName("url2")
    Url2("url2"),
    @SerialName("url3")
    Url3("url3");
}

@Serializable
enum class StoreType(val value: String) {
    @SerialName("카페.디저트")
    카페디저트("카페.디저트");
}



