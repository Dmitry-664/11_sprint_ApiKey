package com.example.a11_sprint_apikey.ui.poster

import android.app.Activity
import android.os.Bundle
import com.example.a11_sprint_apikey.R
import com.example.a11_sprint_apikey.Util.Creator

class PosterActivity : Activity() {

    private val posterController = Creator.providePosterController(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poster)
        posterController.onCreate()
    }
}
