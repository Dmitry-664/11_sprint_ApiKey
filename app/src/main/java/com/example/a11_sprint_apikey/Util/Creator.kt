package com.example.a11_sprint_apikey.Util

import android.content.Context
import com.example.a11_sprint_apikey.data.MoviesRepositoryImpl
import com.example.a11_sprint_apikey.data.network.RetrofitNetworkClient
import com.example.a11_sprint_apikey.domain.api.MoviesInteractor
import com.example.a11_sprint_apikey.domain.api.MoviesRepository
import com.example.a11_sprint_apikey.domain.impl.MoviesInteractorImpl
import com.example.a11_sprint_apikey.presentation.movies.MoviesSearchPresenter
import com.example.a11_sprint_apikey.presentation.poster.PosterPresenter
import com.example.a11_sprint_apikey.presentation.movies.MoviesView
import com.example.a11_sprint_apikey.presentation.poster.PosterView

object Creator {
    private fun getMoviesRepository(context: Context): MoviesRepository {
        return MoviesRepositoryImpl(RetrofitNetworkClient(context))
    }

    fun provideMoviesInteractor(context: Context): MoviesInteractor {
        return MoviesInteractorImpl(getMoviesRepository(context))
    }

    fun provideMoviesSearchPresenter(context: Context): MoviesSearchPresenter {
        return MoviesSearchPresenter(context = context)
    }

    fun providePosterPresenter(posterView: PosterView, imageUrl: String): PosterPresenter {
        return PosterPresenter(posterView, imageUrl)
    }
}