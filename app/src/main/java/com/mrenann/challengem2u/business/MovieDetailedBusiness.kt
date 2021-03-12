package com.mrenann.challengem2u.business

import android.content.Context
import com.mrenann.challengem2u.api.ResponseAPI
import com.mrenann.challengem2u.extensions.getFullImagePath
import com.mrenann.challengem2u.model.movieDetailed.MovieDetailed
import com.mrenann.challengem2u.model.movieGenres.GenresMovie
import com.mrenann.challengem2u.repository.MovieDetailedRepository

class MovieDetailedBusiness(){

    private val repository:MovieDetailedRepository by lazy {
        MovieDetailedRepository()
    }

    suspend fun getMovie(movieId: Int): ResponseAPI {
        val response = repository.getMovie(movieId)
        return if (response is ResponseAPI.Success) {
            val movie = response.data as MovieDetailed
            if(movie.overview == "") {
                movie.overview = "Sinopse não encontrada"
            }
            movie.poster_path = movie.poster_path?.getFullImagePath()
            movie.backdrop_path?.let { string ->
                movie.backdrop_path = string.getFullImagePath()
            }?: run {
                movie.backdrop_path = movie.poster_path
            }

            movie.recommendations?.results?.forEach {
                it.posterPath = it.posterPath?.getFullImagePath()
            }

            movie.similar?.results?.forEach {
                it.posterPath = it.posterPath?.getFullImagePath()
            }

            ResponseAPI.Success(movie)
        } else {
            response
        }
    }

}