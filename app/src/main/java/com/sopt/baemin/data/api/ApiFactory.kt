package com.sopt.baemin.data.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.sopt.baemin.BuildConfig.*
import com.sopt.baemin.data.service.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object ApiFactory {
    private const val CONTENT_TYPE = "application/json"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                if (DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
            })
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(Json.asConverterFactory(CONTENT_TYPE.toMediaType()))
        .client(okHttpClient)
        .build()

    inline fun <reified T> create(): T = retrofit.create(T::class.java)

    object ServicePool {
        val baeminService = create<BaeminService>()
        val foodListReviewService = create<FoodListReviewService>()
        val menuDetailService = create<MenuDetailService>()

        val menuService = create<MenuService>()
        val reviewService = create<ReviewService>()

        val cartService = create<CartService>()

    }
}
