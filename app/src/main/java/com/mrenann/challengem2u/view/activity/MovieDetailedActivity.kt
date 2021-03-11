package com.mrenann.challengem2u.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.mrenann.challengem2u.R
import com.mrenann.challengem2u.databinding.ActivityMovieDetailedBinding
import com.mrenann.challengem2u.model.movieDetailed.MovieDetailed
import com.mrenann.challengem2u.viewModel.MovieDetailedViewModel

class MovieDetailedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailedBinding
    private var movieDetails: MovieDetailed? = null
    private lateinit var viewModelMovie: MovieDetailedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModelMovie = ViewModelProvider(this).get(MovieDetailedViewModel::class.java)

        viewModelMovie.getMovie(372058)

        viewModelMovie.movieSucess.observe(this){
            movieDetails = it

            Glide.with(this)
                .load(it.poster_path)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.IvPoster)

            binding.tVmovietitle.text = it.title
            binding.tVLikesCount.text = "${it.vote_count} Likes"
            binding.tVPopularityCount.text = "${it.popularity} Views"
        }

    }
}