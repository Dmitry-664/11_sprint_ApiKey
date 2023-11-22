package com.example.a11_sprint_apikey.ui.poster

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.a11_sprint_apikey.R
import com.example.a11_sprint_apikey.Util.Creator
import com.example.a11_sprint_apikey.presentation.poster.PosterPresenter
import com.example.a11_sprint_apikey.presentation.poster.PosterView

class PosterActivity : Activity(), PosterView {
    private lateinit var poster: ImageView
    private lateinit var posterPresenter: PosterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageUrl = intent.extras?.getString("poster", "") ?: ""
        posterPresenter = Creator.providePosterPresenter(this, imageUrl)
        setContentView(R.layout.activity_poster)
        posterPresenter.onCreate()
    }

    override fun setupPosterImage(url: String) {
        Glide.with(applicationContext)
            .load(url)
            .into(poster)
    }
}
