package com.example.dam2_parcial1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dam2_parcial1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}