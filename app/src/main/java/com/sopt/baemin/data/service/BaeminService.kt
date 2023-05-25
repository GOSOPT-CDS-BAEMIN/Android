package com.sopt.baemin.data.service

import com.sopt.baemin.data.model.response.RestaurantListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
/*/store?type="type*/
interface BaeminService {
    @GET("store")
    fun getRestaurntList(
        @Query("type") type:Int
    ): Response<RestaurantListResponse>
}