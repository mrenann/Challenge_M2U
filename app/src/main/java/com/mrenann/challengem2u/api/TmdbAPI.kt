package com.mrenann.challengem2u.api

import com.mrenann.challengem2u.model.movieDetailed.MovieDetailed
import com.mrenann.challengem2u.model.movieGenres.GenresMovie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TmdbAPI {

    @GET("movie/{movie_id}")
    suspend fun movieDetails(
        @Path("movie_id") movieId: Int
    ): Response<MovieDetailed>

    @GET("genre/movie/list")
    suspend fun movieGenres(): Response<GenresMovie>


}