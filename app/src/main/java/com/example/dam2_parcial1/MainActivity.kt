package com.example.dam2_parcial1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.RecyclerListener
import com.example.dam2_parcial1.RetrofitClient.apiService
import com.example.dam2_parcial1.adapter.QueryAdapter
import com.example.dam2_parcial1.databinding.ActivityMainBinding
import com.example.dam2_parcial1.model.QueryResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.log


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var queryAdapter: QueryAdapter
    private val apiService = RetrofitClient.apiService
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiKey = BuildConfig.MY_API_KEY
        binding.rvResults.layoutManager = LinearLayoutManager(this)

        binding.svIngredient.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    searchRecipes(it, apiKey)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        queryAdapter = QueryAdapter(emptyList()) { query ->
            val intent = Intent(this, RecipeDetailActivity::class.java)
            intent.putExtra("RECIPE_ID", query.id)
            startActivity(intent)
        }
        binding.rvResults.adapter = queryAdapter

    }

    private fun searchRecipes(ingredient: String, apiKey: String) {
        coroutineScope.launch {
            try {
                val response = apiService.searchRecipes(ingredient, apiKey)
                updateUI(response)
            } catch (e: Exception) {
                Log.e("Error:", "${e.message}")
            }
        }
    }

    private suspend fun updateUI(response: QueryResponse) {
        withContext(Dispatchers.Main) {
            queryAdapter.updateResults(response.results)
        }
    }
}