package com.example.a11_sprint_apikey.presentation.poster

import com.bumptech.glide.Glide
import com.example.a11_sprint_apikey.R

class PosterPresenter(private val view: PosterView,private val imageUrl: String) {


    fun onCreate() {
        view.setupPosterImage(imageUrl)
    }
}