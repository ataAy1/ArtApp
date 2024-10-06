package com.example.artbookk.api

import com.atilsamancioglu.artbookhilttesting.model.ImageResponse
import com.example.artbookk.util.Util
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPI {

    @GET("/api/")
    suspend fun imageSearch(
        @Query("q") searchQuery: String,
        @Query("key") apiKey: String = Util.API_KEY

    ): Response<ImageResponse>
}