package com.example.a11_sprint_apikey

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IMDbApi {
    @GET("/en/API/SearchMovie/{apiKey}/{expression}")
    fun searchMovies(
        @Path("apiKey") apiKey: String,
        @Path("expression") expression: String
    ) : Call<MainActivity.SearchResponse>
}