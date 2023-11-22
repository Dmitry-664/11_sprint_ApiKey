package com.example.a11_sprint_apikey.ui.movies

import android.app.Application
import com.example.a11_sprint_apikey.presentation.movies.MoviesSearchPresenter

class MoviesApplication : Application() {
    var moviesSearchPresenter : MoviesSearchPresenter? = null
}