package com.mrenann.challengem2u.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrenann.challengem2u.api.ResponseAPI
import com.mrenann.challengem2u.business.GenresMovieBusiness
import com.mrenann.challengem2u.model.movieGenres.GenresMovie
import kotlinx.coroutines.launch

class MovieGenresViewModel: ViewModel() {
    val onResultGenres: MutableLiveData<GenresMovie> = MutableLiveData()
    private val onResultFailure: MutableLiveData<String> = MutableLiveData()

    private val business by lazy {
        GenresMovieBusiness()
    }

    fun getGenres() {
        viewModelScope.launch {
            when (val response = business.getGenres()) {
                is ResponseAPI.Success -> {
                    onResultGenres.postValue(
                        response.data as GenresMovie
                    )
                }
                is ResponseAPI.Error -> {
                    onResultFailure.postValue(response.message)
                }
            }
        }
    }
}