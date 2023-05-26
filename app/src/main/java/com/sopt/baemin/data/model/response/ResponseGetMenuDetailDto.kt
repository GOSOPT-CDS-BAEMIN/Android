package com.sopt.baemin.data.model.response

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResponseGetMenuDetailDto (
    @SerialName("status")
    val status: Long? = null,
    @SerialName("success")
    val success: Boolean? = null,
    @SerialName("message")
    val message: String? = null,
    @SerialName("data")
    val data: Food? = null
)