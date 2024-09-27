package com.example.dam2_parcial1

import com.example.dam2_parcial1.model.QueryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("recipes/complexSearch")
    suspend fun searchRecipes(
        @Query("query") ingredient: String,  // Ingredient the user wants
        @Query("apiKey") apiKey: String  // Spoonacular ApiKey
    ): QueryResponse
}