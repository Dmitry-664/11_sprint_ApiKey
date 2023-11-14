package com.example.a11_sprint_apikey.data.dto

import com.example.a11_sprint_apikey.domain.models.Movie

class MoviesSearchResponse(
    val searchType: String,
    val expression: String,
    val results: List<MovieDto>
) : Response()
