package com.example.bvcassignment

import com.google.gson.annotations.SerializedName


data class MovieResponse(
    @SerializedName("Search") val searchResults: List<Movie>
)
