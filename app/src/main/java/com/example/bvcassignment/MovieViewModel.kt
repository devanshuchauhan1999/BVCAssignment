package com.example.bvcassignment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    private val movieRepository = MovieRepository()

    fun searchMovies(query: String) {
        viewModelScope.launch {
            val moviesResult = movieRepository.searchMovies(query)
            Log.d("TAG", "searchMovies: $moviesResult")
            _movies.value = moviesResult
        }
    }
}
