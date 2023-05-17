package com.example.bvcassignment

import retrofit2.Response


import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("/")
    suspend fun searchMovies(
        @Query("apikey") apiKey: String,
        @Query("s") query: String,
        @Query("type") type: String
    ): Response<MovieResponse>
}
