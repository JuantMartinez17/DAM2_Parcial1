package com.example.dam2_parcial1.model

import com.google.gson.annotations.SerializedName

data class QueryResponse(
    @SerializedName("results")
    val results: List<Query>
)
