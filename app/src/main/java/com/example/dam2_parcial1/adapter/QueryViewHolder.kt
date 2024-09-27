package com.example.dam2_parcial1.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.dam2_parcial1.databinding.CardItemBinding
import com.example.dam2_parcial1.model.Query
import com.squareup.picasso.Picasso

class QueryViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = CardItemBinding.bind(view)

    fun bind(query: Query){
        //set recipe title
        binding.tvItemTitle.text = query.title
        //load recipe image using picasso
        val imageUrl = query.image
        Picasso.with(binding.ivItemImage.context)
            .load(imageUrl)
            .into(binding.ivItemImage)
    }
}