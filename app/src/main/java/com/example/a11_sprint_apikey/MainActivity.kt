package com.example.a11_sprint_apikey

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private val imdbBaseUrl = "https://imdb-api.com"
    private val apiKey = "k_nh70jz70"
    private val retrofit = Retrofit.Builder()
        .baseUrl(imdbBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val imdbServise = retrofit.create(IMDbApi::class.java)

    private lateinit var searchButton: Button
    private lateinit var queryInput: EditText
    private lateinit var placeholderMessage: TextView
    private lateinit var moviesList: RecyclerView

    private val movies = ArrayList<Movie>()
    private val adapter = SearchAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchButton = findViewById(R.id.searchButton)
        queryInput = findViewById(R.id.queryInput)
        moviesList = findViewById(R.id.locations)
        placeholderMessage = findViewById(R.id.placeholderMessage)

        adapter.movies = movies
        moviesList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        moviesList.adapter = adapter

        searchButton.setOnClickListener {
            if (queryInput.text.isNotEmpty()) {
                imdbServise.searchMovies(apiKey, queryInput.text.toString()).enqueue(object :
                    Callback<SearchResponse> {
                    override fun onResponse(
                        call: Call<SearchResponse>,
                        response: Response<SearchResponse>
                    ) {
                        if (response.code() == 200) {
                            movies.clear()
                            if (response.body()?.result?.isNotEmpty() == true) {
                                movies.addAll(response.body()?.result!!)
                                adapter.notifyDataSetChanged()
                            }
                            if (movies.isEmpty()) {
                                showMessage(getString(R.string.nothing_found), "")
                            } else {
                                showMessage("", "")
                            }
                        } else {
                            showMessage(
                                getString(R.string.something_went_wrong),
                                response.code().toString()
                            )
                        }
                    }

                    override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                        showMessage(getString(R.string.something_went_wrong), t.message.toString())
                    }
                })
            }
        }

    }

    private fun showMessage(text: String, additionalMessage: String) {
        if (text.isNotEmpty()) {
            placeholderMessage.visibility = View.VISIBLE
            movies.clear()
            adapter.notifyDataSetChanged()
            placeholderMessage.text = text
            if (additionalMessage.isNotEmpty()) {
                Toast.makeText(applicationContext, additionalMessage, Toast.LENGTH_LONG)
                    .show()
            }
        } else {
            placeholderMessage.visibility = View.GONE
        }
    }

    data class SearchResponse(
        val searchType: String,
        val expression: String,
        val result: List<Movie>
    )

    data class Movie(
        val id: String,
        val resultType: String,
        val image: String,
        val title: String,
        val description: String
    )
}