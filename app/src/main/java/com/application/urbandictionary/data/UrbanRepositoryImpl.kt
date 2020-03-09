package com.application.urbandictionary.data

import com.application.urbandictionary.data.models.ApiResponse
import com.application.urbandictionary.domain.UrbanRepository
import retrofit2.Response
import javax.inject.Inject

class UrbanRepositoryImpl @Inject constructor(val api: Api) : UrbanRepository {

    private var definitionsCache = mutableMapOf<String, ApiResponse>()


    override suspend fun getDefinitions(search: String): Response<ApiResponse> {
        val result = api.getSearchDefinitions(search)
        if (result.isSuccessful)
        // storing in a temp cache
            result.body()?.let {
                definitionsCache.put(search, it)
            }
        return result
    }

}