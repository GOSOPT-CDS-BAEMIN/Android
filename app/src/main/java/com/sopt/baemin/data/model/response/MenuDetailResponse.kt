package com.sopt.baemin.data.model.response

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class MenuDetailResponse (
    @SerialName("status")
    val status: Long? = null,
    @SerialName("success")
    val success: Boolean? = null,
    @SerialName("message")
    val message: String? = null,
    @SerialName("data")
    val data: Data? = null
)

@Serializable
data class Data (
    @SerialName("foodId")
    val foodID: Int? = null,
    @SerialName("foodName")
    val foodName: String? = null,
    @SerialName("price")
    val price: Int? = null,
    @SerialName("foodDescription")
    val foodDescription: String? = null,
    @SerialName("foodImageUrl")
    val foodImageURL: String? = null,
)
