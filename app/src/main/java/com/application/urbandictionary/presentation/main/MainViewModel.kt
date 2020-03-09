package com.application.urbandictionary.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.application.urbandictionary.data.models.Definition
import com.application.urbandictionary.domain.GetListOfDefinitionsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val getListOfDefinitionsUseCase: GetListOfDefinitionsUseCase) :
    ViewModel() {
    private var apiResponse = MutableLiveData<List<Definition>>()
    var searchResultLiveData: LiveData<List<Definition>> = apiResponse

    fun search(term: String) {
        viewModelScope.launch {
            val result = getListOfDefinitionsUseCase.getListOfDefinitionsUseCase(term)
            result?.let { it ->
                apiResponse.postValue(it.list)
            } ?: apiResponse.postValue(emptyList())
        }
    }
}
