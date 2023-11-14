package com.example.a11_sprint_apikey.domain.impl

import com.example.a11_sprint_apikey.Util.Resource
import com.example.a11_sprint_apikey.domain.api.MoviesInteractor
import com.example.a11_sprint_apikey.domain.api.MoviesRepository
import java.util.concurrent.Executors

class MoviesInteractorImpl(private val repository: MoviesRepository) : MoviesInteractor {

    private val executor = Executors.newCachedThreadPool()

    override fun searchMovies(expression: String, consumer: MoviesInteractor.MoviesConsumer) {
        executor.execute {
            when(val resource = repository.searchMovies(expression)) {
                is Resource.Success -> { consumer.consume(resource.data, null) }
                is Resource.Error -> { consumer.consume(null, resource.message) }
            }
        }
    }
}

//class MoviesInteractorImpl(private val repository: MoviesRepository) : MoviesInteractor {
//
//    override fun searchMovies(expression: String, consumer: MoviesInteractor.MoviesConsumer) {
//        val t = Thread {
//            consumer.consume(repository.searchMovies(expression))
//        }
//        t.start()
//    }
//}