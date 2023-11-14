package com.example.a11_sprint_apikey.data.network

import com.example.a11_sprint_apikey.Util.Resource
import com.example.a11_sprint_apikey.data.NetworkClient
import com.example.a11_sprint_apikey.data.dto.MoviesSearchRequest
import com.example.a11_sprint_apikey.data.dto.MoviesSearchResponse
import com.example.a11_sprint_apikey.domain.api.MoviesRepository
import com.example.a11_sprint_apikey.domain.models.Movie

class MoviesRepositoryImpl(private val networkClient: NetworkClient) : MoviesRepository {

    override fun searchMovies(expression: String): Resource<List<Movie>> {
        val response = networkClient.doRequest(MoviesSearchRequest(expression))
        return when (response.resultCode) {
            -1 -> {
                Resource.Error("Проверьте подключение к интернету")
            }
            200 -> {
                Resource.Success((response as MoviesSearchResponse).results.map {
                    Movie(it.id, it.resultType, it.image, it.title, it.description)})
            }
            else -> {
                Resource.Error("Ошибка сервера")
            }
        }
    }
}

