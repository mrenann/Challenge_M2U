package com.mrenann.challengem2u.repository

import com.mrenann.challengem2u.api.ResponseAPI
import com.mrenann.challengem2u.api.ResponseAPI.Success
import com.mrenann.challengem2u.model.movieDetailed.MovieDetailed
import com.mrenann.challengem2u.repository.MovieDetailedRepository
import com.nhaarman.mockitokotlin2.spy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MovieDetailedRepositoryTest {

    private val mainThreadSurrogate = newSingleThreadContext("MoviesRepository thread")
    private lateinit var repository: MovieDetailedRepository

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
        repository = MovieDetailedRepository()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun `Está pegando o filme da API corretamente`(): Unit = runBlocking {
        launch(Dispatchers.Main) {
            val response = repository.getMovie(372058)
            assertTrue(response is Success)
        }
    }
}