package com.example.bvcassignment

import com.example.bvcassignment.Movie
import com.example.bvcassignment.MovieApiService
import retrofit2.Retrofit


import retrofit2.converter.gson.GsonConverterFactory

class MovieRepository {
    private val apiKey = "b9bd48a6"
    private val type = "movie"
    private val apiService: MovieApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(MovieApiService::class.java)
    }

    suspend fun searchMovies(query: String): List<Movie> {
        val response = apiService.searchMovies(apiKey, query,type )
        return if (response.isSuccessful) {
            response.body()?.searchResults ?: emptyList()
        } else {
            emptyList()
        }
    }
}
