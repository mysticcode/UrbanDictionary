package com.application.urbandictionary.domain

import com.application.urbandictionary.data.models.ApiResponse
import javax.inject.Inject

class GetListOfDefinitionsUseCase @Inject constructor(val urbanRespository: UrbanRepository) {

    suspend fun getListOfDefinitionsUseCase(search: String): ApiResponse? {
        val result = urbanRespository.getDefinitions(search)
        if (result.isSuccessful)
            return result.body()
        else
            return null
    }
}