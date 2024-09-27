package com.example.dam2_parcial1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dam2_parcial1.RetrofitClient
import com.example.dam2_parcial1.model.Query
import kotlinx.coroutines.launch

class ViewModel: ViewModel() {
    val results = MutableLiveData<List<Query>>()
    val errorMessage = MutableLiveData<String>()

    fun getResults(apiKey: String, query: String){
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.searchRecipes(query, 10, apiKey)
                results.postValue(response.results)
            }catch (e: Exception){
                errorMessage.postValue("Error: ${e.message}")
            }
        }
    }

}