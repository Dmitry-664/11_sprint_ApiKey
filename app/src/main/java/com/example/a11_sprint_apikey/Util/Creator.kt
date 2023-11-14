package com.example.a11_sprint_apikey.Util

import android.app.Activity
import android.content.Context
import com.example.a11_sprint_apikey.data.network.MoviesRepositoryImpl
import com.example.a11_sprint_apikey.data.network.RetrofitNetworkClient
import com.example.a11_sprint_apikey.domain.api.MoviesInteractor
import com.example.a11_sprint_apikey.domain.api.MoviesRepository
import com.example.a11_sprint_apikey.domain.impl.MoviesInteractorImpl
import com.example.a11_sprint_apikey.presentation.MoviesSearchController
import com.example.a11_sprint_apikey.presentation.PosterController
import com.example.a11_sprint_apikey.ui.movies.MoviesAdapter

object Creator {
    private fun getMoviesRepository(context: Context): MoviesRepository {
        return MoviesRepositoryImpl(RetrofitNetworkClient(context))
    }

    fun provideMoviesInteractor(context: Context): MoviesInteractor {
        return MoviesInteractorImpl(getMoviesRepository(context))
    }

    fun provideMoviesSearchController(activity: Activity, adapter: MoviesAdapter): MoviesSearchController {
        return MoviesSearchController(activity, adapter)
    }

    fun providePosterController(activity: Activity): PosterController {
        return PosterController(activity)
    }
}