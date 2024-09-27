package com.example.dam2_parcial1

import com.example.dam2_parcial1.model.QueryResponse
import com.example.dam2_parcial1.model.RecipeDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("recipes/complexSearch")
    suspend fun searchRecipes(
        @Query("query") ingredient: String,  // Ingredient the user wants
        @Query("apiKey") apiKey: String  // Spoonacular ApiKey
    ): QueryResponse

    @GET("recipes/{id}/nutritionWidget.json")
    fun getRecipeDetails(
        @Path("id")
        recipeId: Int,
        @Query("apiKey")
        apiKey: String,
    ): Call<RecipeDetail>
}