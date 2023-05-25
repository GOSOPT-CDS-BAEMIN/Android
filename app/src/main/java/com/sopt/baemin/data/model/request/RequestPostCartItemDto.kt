package com.sopt.baemin.data.model.request

import kotlinx.serialization.Serializable

@Serializable
data class RequestPostCartItemDto(
    val storeId: Long,
    val foodId: Long,
    val foodCount: Int
)