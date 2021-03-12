package com.mrenann.challengem2u.repository

import com.mrenann.challengem2u.api.APIService
import com.mrenann.challengem2u.api.ResponseAPI
import java.lang.Exception

class GenresMovieRepository {
    suspend fun getGenderMovies(): ResponseAPI {
        return try {
            val response = APIService.tmdbApi.movieGenres()

            if (response.isSuccessful) {
                ResponseAPI.Success(response.body())
            } else {
                if (response.code() == 404) {
                    ResponseAPI.Error("Dado não encontrado")
                } else {
                    ResponseAPI.Error("Erro ao carregar os dados")
                }
            }
        } catch (exception: Exception) {
            ResponseAPI.Error("Erro ao carregar os dados")
        }
    }
}