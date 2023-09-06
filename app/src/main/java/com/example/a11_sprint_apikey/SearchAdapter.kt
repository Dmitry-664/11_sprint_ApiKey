package com.example.a11_sprint_apikey

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SearchAdapter() : RecyclerView.Adapter<SearchViewHolder>() {
    var movies = ArrayList<MainActivity.Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder = SearchViewHolder(parent)

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(movies.get(position))
    }

    override fun getItemCount(): Int = movies.size
}