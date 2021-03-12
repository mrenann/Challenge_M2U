package com.mrenann.challengem2u.business

import com.mrenann.challengem2u.api.ResponseAPI

import com.mrenann.challengem2u.model.movieGenres.GenresMovie
import com.mrenann.challengem2u.repository.GenresMovieRepository

class GenresMovieBusiness {
    private val repository by lazy {
        GenresMovieRepository()
    }

    suspend fun getGenres(): ResponseAPI {
        val response = repository.getGenderMovies()
        return if (response is ResponseAPI.Success) {
            val genres = response.data as GenresMovie
            ResponseAPI.Success(genres)
        } else {
            response
        }
    }
}