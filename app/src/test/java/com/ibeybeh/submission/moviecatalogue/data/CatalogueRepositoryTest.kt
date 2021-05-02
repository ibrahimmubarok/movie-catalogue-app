package com.ibeybeh.submission.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ibeybeh.submission.moviecatalogue.data.source.remote.LoadMoviesCallback
import com.ibeybeh.submission.moviecatalogue.data.source.remote.RemoteDataSource
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.model.MoviesData
import com.ibeybeh.submission.moviecatalogue.utils.LiveDataTestUtil
import junit.framework.TestCase
import org.junit.*
import org.mockito.Mockito.*

class CatalogueRepositoryTest : TestCase() {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val catalogueRepository = FakeCatalogueRepository(remote)

    private val apiKey = "224f6797a2665e28bce03b9e0655510a"
    private val language = "en-US"

    private fun movieResponse(): ArrayList<MoviesData> {
        val movies = ArrayList<MoviesData>()
        RemoteDataSource().getAllMovies(object : LoadMoviesCallback {
            override fun onAllMoviesReceived(moviesResponse: MutableList<MoviesData>) {
                movies.addAll(moviesResponse)
            }
        }, apiKey = apiKey, language = language)
        return movies
    }

    @Test
    fun testGetAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as LoadMoviesCallback)
                .onAllMoviesReceived(movieResponse())
            null
        }.`when`(remote).getAllMovies(object : LoadMoviesCallback {
            val movies = ArrayList<MoviesData>()
            override fun onAllMoviesReceived(moviesResponse: MutableList<MoviesData>) {
                movies.addAll(moviesResponse)
            }
        }, apiKey, language)
        val movie = LiveDataTestUtil.getValue(catalogueRepository.getAllMovies(apiKey, language))
        verify(remote).getAllMovies(any(), apiKey, language)
        assertNotNull(movie)
        assertEquals(movieResponse().size.toLong(), movie.size.toLong())
    }

    fun testGetByIdMovies() {}

    fun testGetAllTvShows() {}

    fun testGetByIdTvShows() {}
}