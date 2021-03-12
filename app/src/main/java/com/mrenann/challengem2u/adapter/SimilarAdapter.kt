package com.mrenann.challengem2u.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.mrenann.challengem2u.R
import com.mrenann.challengem2u.databinding.ActivitySplashBinding
import com.mrenann.challengem2u.databinding.CardMovieBinding
import com.mrenann.challengem2u.extensions.getFirst4Chars
import com.mrenann.challengem2u.model.movieDetailed.MovieResult
import com.mrenann.challengem2u.model.movieGenres.GenresMovie
import com.mrenann.challengem2u.view.activity.MovieDetailedActivity
import com.mrenann.challengem2u.viewModel.MovieGenresViewModel

class SimilarAdapter(
    private var filmList: List<MovieResult>,
    private var genres:GenresMovie,
    private val onMovieClicked: (MovieResult?) -> Unit
): RecyclerView.Adapter<SimilarAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CardMovieBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding,genres)
    }

    override fun getItemCount(): Int {
        return filmList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(filmList[position],onMovieClicked)
    }

    class ViewHolder(
        private val binding: CardMovieBinding,
        private val genres: GenresMovie
    ): RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(movie: MovieResult?, onMovieClicked: (MovieResult?) -> Unit) = with(binding) {

            var generosText =""
            Glide.with(itemView.context)
                .load(movie?.posterPath)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.logo)
                .into(binding.iVPoster)

            binding.tVMovieName.text = movie?.title
            binding.tVMovieYear.text = movie?.releaseDate?.getFirst4Chars() ?: "Unknow"

            movie?.genreIds?.forEach { genreFilm ->
                genres.genres.forEach { genre ->
                    if (genre.id == genreFilm) {
                        generosText += "${genre.name},"
                    }
                }
            }

            binding.tVMovieGenres.text = generosText
            var checked = false
            binding.checkBtn.setOnClickListener {

                it as LottieAnimationView
                if(checked) {
                    it.speed = -2f
                    it.playAnimation()
                } else {
                    it.speed = 2f
                    it.playAnimation()
                }
                checked = !checked
            }

            itemView.setOnClickListener {
                onMovieClicked(movie)
            }

        }

    }
}