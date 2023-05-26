package com.sopt.baemin.data.entity

import androidx.annotation.DrawableRes

data class FoodDummy(
    val id: Int,
    val name: String,
    val price: Int,
    @DrawableRes
    val imgRes: Int,
    val num: Int
)