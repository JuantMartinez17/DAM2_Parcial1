package com.example.dam2_parcial1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dam2_parcial1.R
import com.example.dam2_parcial1.model.Query

class QueryAdapter (var results: List<Query>): RecyclerView.Adapter<QueryViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QueryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return QueryViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return results.size
    }

    override fun onBindViewHolder(holder: QueryViewHolder, position: Int) {
        val item = results[position]
        holder.bind(item)
    }

}