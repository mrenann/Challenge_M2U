package com.mrenann.challengem2u.utils

class Constants {

    object Api {
        const val BASE_URL_v3 = "https://api.themoviedb.org/3/"
        const val BASE_URL_ORIGINAL_IMAGE = "https://image.tmdb.org/t/p/original"
        const val API_AUTH_NAME = "Authorization"
        const val API_AUTH_VALUE = "Bearer YOUR_KEY"
        const val API_CONTENT_TYPE_NAME = "Content-Type"
        const val API_CONTENT_TYPE_VALUE = "application/json;charset=utf-8"
        const val QUERY_PARAM_LANGUAGE_LABEL = "language"
        const val QUERY_PARAM_LANGUAGE_VALUE = "pt-BR"
        const val QUERY_PARAM_REGION_LABEL = "region"
        const val QUERY_PARAM_REGION_VALUE = "BR"
        const val QUERY_PARAM_APPEND_LABEL = "append_to_response"
        const val QUERY_PARAM_APPEND_VALUE = "recommendations,similar"
    }

    object ConstantsFilms {
        const val BASE_MOVIE_KEY = "Movie"
        const val BASE_GENRES_KEY = "Genres"
    }

}