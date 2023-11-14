package com.example.a11_sprint_apikey.domain.api

import com.example.a11_sprint_apikey.domain.models.Movie

interface MoviesInteractor {
    fun searchMovies (expression: String, consumer: MoviesConsumer)
    interface MoviesConsumer {
        fun consume(foundMovies: List<Movie>?, errorMessage: String?)
    }
}