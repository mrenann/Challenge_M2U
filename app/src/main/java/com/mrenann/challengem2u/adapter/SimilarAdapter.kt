package com.mrenann.challengem2u.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.mrenann.challengem2u.R
import com.mrenann.challengem2u.databinding.CardMovieBinding
import com.mrenann.challengem2u.extensions.getFirst4Chars
import com.mrenann.challengem2u.model.movieDetailed.MovieResult

class SimilarAdapter(
    private var filmList: List<MovieResult>,
    private val onMovieClicked: (MovieResult?) -> Unit
): RecyclerView.Adapter<SimilarAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CardMovieBinding.inflate(layoutInflater, parent, false)
        return SimilarAdapter.ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return filmList.size
    }
    override fun onBindViewHolder(holder: SimilarAdapter.ViewHolder, position: Int) {
        holder.bind(filmList[position],onMovieClicked)
    }

    class ViewHolder(
        private val binding: CardMovieBinding
    ): RecyclerView.ViewHolder(
        binding.root
    ) {
        private var checked:Boolean = false
        fun bind(movie: MovieResult?, onMovieClicked: (MovieResult?) -> Unit) = with(binding) {
            Glide.with(itemView.context)
                .load(movie?.posterPath)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.logo)
                .into(binding.iVPoster)

            binding.tVMovieName.text = movie?.title
            binding.tVMovieYear.text = movie?.releaseDate?.getFirst4Chars() ?: "Unknow"

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