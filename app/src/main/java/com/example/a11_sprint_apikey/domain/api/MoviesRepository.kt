package com.example.a11_sprint_apikey.domain.api

import com.example.a11_sprint_apikey.Util.Resource
import com.example.a11_sprint_apikey.domain.models.Movie

interface MoviesRepository {
    fun searchMovies(expression: String): Resource<List<Movie>>
}