package com.example.bvcassignment


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bvcassignment.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieViewModel = ViewModelProvider(this)[MovieViewModel::class.java]

        movieAdapter = MovieAdapter()

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = movieAdapter
        }

        movieViewModel.movies.observe(this) { movies ->
            movieAdapter.submitList(movies)
        }

        binding.searchButton.setOnClickListener {
            val query = binding.searchEditText.text.toString()
            movieViewModel.searchMovies(query)
        }
    }
}