package com.sopt.baemin.data.entity


data class StoreDummy(
    val id: Int,
    val name: String,
    val deliveryFee: Int,
    val foods: List<FoodDummy>,
    val totalPrice: Int,
)
