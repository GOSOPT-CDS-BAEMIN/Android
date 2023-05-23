package com.sopt.baemin.data.api

import com.sopt.baemin.data.model.response.MenuResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MenuService {
    @GET("store/{storeId}")
    fun getMenu(
        @Path("storeId") storeId: Int
    ): Call<MenuResponse>
}
