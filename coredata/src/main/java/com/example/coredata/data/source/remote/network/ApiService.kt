package com.example.coredata.data.source.remote.network

import com.example.coredata.data.source.remote.ListNewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("news")
    suspend fun getList(@Query("category") category: String): ListNewsResponse
}