package com.mrenann.challengem2u.repository

import com.mrenann.challengem2u.api.ResponseAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GenresMovieRepositoryTest {

    private val mainThreadSurrogate = newSingleThreadContext("GenresRepository thread")
    private lateinit var repository: GenresMovieRepository

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
        repository = GenresMovieRepository()
    }

    @Test
    fun `Está pegando os gêneros da API corretamente`(): Unit = runBlocking {
        launch(Dispatchers.Main) {
            val response = repository.getGenderMovies()
            Assert.assertTrue(response is ResponseAPI.Success)
        }
    }
}
