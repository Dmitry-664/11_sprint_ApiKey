package com.example.a11_sprint_apikey.presentation.movies

import com.example.a11_sprint_apikey.domain.models.Movie
import com.example.a11_sprint_apikey.ui.movies.MoviesState
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface MoviesView : MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun render(state: MoviesState)
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showToast(additionalMessage: String)
}