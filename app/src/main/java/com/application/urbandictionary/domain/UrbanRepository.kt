package com.application.urbandictionary.domain

import com.application.urbandictionary.data.models.ApiResponse
import retrofit2.Response

interface UrbanRepository {

    suspend fun getDefinitions(search: String): Response<ApiResponse>
}