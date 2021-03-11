package com.mrenann.challengem2u.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.mrenann.challengem2u.R
import com.mrenann.challengem2u.adapter.SimilarAdapter
import com.mrenann.challengem2u.databinding.ActivityMovieDetailedBinding
import com.mrenann.challengem2u.model.movieDetailed.MovieDetailed
import com.mrenann.challengem2u.utils.Constants.ConstantsFilms.BASE_MOVIE_KEY
import com.mrenann.challengem2u.viewModel.MovieDetailedViewModel

class MovieDetailedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailedBinding
    private var movieDetails: MovieDetailed? = null
    private lateinit var viewModelMovie: MovieDetailedViewModel
    private var movieId: Int? = null
    private var hearted:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieId= intent.getIntExtra(BASE_MOVIE_KEY,372058)

        viewModelMovie = ViewModelProvider(this).get(MovieDetailedViewModel::class.java)

        viewModelMovie.getMovie(movieId)

        binding.IbBack.setOnClickListener {
            onBackPressed()
        }

        binding.heartBtn.setOnClickListener {
            it as LottieAnimationView
            if(hearted) {
                it.speed = -2f
                it.playAnimation()
            } else {
                it.speed = 2f
                it.playAnimation()
            }
            hearted = !hearted
        }

        viewModelMovie.movieSucess.observe(this){
            movieDetails = it

            Glide.with(this)
                .load(it.poster_path)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.IvPoster)

            binding.tVmovietitle.text = it.title
            binding.tVLikesCount.text = "${it.vote_count} Likes"
            binding.tVPopularityCount.text = "${it.popularity} Views"

            binding.rVSimilars.apply {
                layoutManager = LinearLayoutManager(this@MovieDetailedActivity, LinearLayoutManager.VERTICAL, false)
                adapter = it.similar?.let { similares ->
                    similares.results?.let { listResults->
                        SimilarAdapter(listResults) { result ->
                            val intent = Intent(this@MovieDetailedActivity, MovieDetailedActivity::class.java)
                            result?.let { resultLet -> intent.putExtra(BASE_MOVIE_KEY, resultLet.id) }
                            startActivity(intent)
                        }
                    }
                }
            }
        }

    }
}