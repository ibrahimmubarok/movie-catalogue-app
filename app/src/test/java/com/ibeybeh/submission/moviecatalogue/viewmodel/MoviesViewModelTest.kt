package com.ibeybeh.submission.moviecatalogue.viewmodel

import com.ibeybeh.submission.moviecatalogue.utils.DataDummyHelper
import junit.framework.TestCase
import org.junit.*

class MoviesViewModelTest : TestCase() {

    private lateinit var moviesViewModel: MoviesViewModel
    private val listMovies = DataDummyHelper.generateDummyMovies()[7]
    private val id = listMovies.id

    @Before
    override fun setUp() {
        moviesViewModel = MoviesViewModel()
        if (id != null) {
            moviesViewModel.setSelectedMovies(id)
        }
    }

    @Test
    fun testGetDataDummyListMovies() {
        val moviesList = moviesViewModel.getDataDummyListMovies()
        assertNotNull(moviesList)
        assertEquals(10, moviesList.size)
    }

    @Test
    fun testGetDataDummyMovies() {
        listMovies.id?.let { id ->
            moviesViewModel.setSelectedMovies(id)
        }
        val movies = moviesViewModel.getDataDummyMovies()
        assertNotNull(movies)
        assertEquals(listMovies.id, movies.id)
        assertEquals(listMovies.photo, movies.photo)
        assertEquals(listMovies.backdropPath, movies.backdropPath)
        assertEquals(listMovies.genre, movies.genre)
        assertEquals(listMovies.title, movies.title)
        assertEquals(listMovies.releaseDate, movies.releaseDate)
        assertEquals(listMovies.rating, movies.rating)
        assertEquals(listMovies.runtime, movies.runtime)
        assertEquals(listMovies.homepage, movies.homepage)
        assertEquals(listMovies.overview, movies.overview)
    }
}