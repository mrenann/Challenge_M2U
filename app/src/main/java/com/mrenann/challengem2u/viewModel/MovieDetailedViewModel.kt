package com.mrenann.challengem2u.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrenann.challengem2u.api.ResponseAPI
import com.mrenann.challengem2u.business.MovieDetailedBusiness
import com.mrenann.challengem2u.model.movieDetailed.MovieDetailed
import kotlinx.coroutines.launch

class MovieDetailedViewModel: ViewModel() {
    val movieSucess: MutableLiveData<MovieDetailed> = MutableLiveData()
    private val movieError: MutableLiveData<String> = MutableLiveData()

    private val detailed by lazy {
        MovieDetailedBusiness()
    }

    fun getMovie(movieId: Int?) {
        viewModelScope.launch {
            when(val response = movieId?.let { detailed.getMovie(it) }) {
                is ResponseAPI.Success -> {
                    movieSucess.postValue(response.data as MovieDetailed)
                }
                is ResponseAPI.Error -> {
                    movieError.postValue(response.message)
                }
            }
        }
    }

}