package com.application.urbandictionary.data

import com.application.urbandictionary.data.models.ApiResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface Api {
    @Headers(
        "x-rapidapi-host:mashape-community-urban-dictionary.p.rapidapi.com",
        "x-rapidapi-key:api-key"
    )
    @GET("define")
    suspend fun getSearchDefinitions(@Query("term") search: String): Response<ApiResponse>
}