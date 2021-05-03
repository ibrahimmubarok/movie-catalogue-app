package com.ibeybeh.submission.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ibeybeh.submission.moviecatalogue.data.source.remote.RemoteDataSource
import com.ibeybeh.submission.moviecatalogue.data.source.remote.RemoteDataSource.LoadMoviesCallback
import com.ibeybeh.submission.moviecatalogue.utils.DataDummy
import com.ibeybeh.submission.moviecatalogue.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class CatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val catalogueRepository = FakeCatalogueRepository(remote)

    private val apiKey = "224f6797a2665e28bce03b9e0655510a"
    private val language = "en-US"

    private val moviesResponse = DataDummy.dataDummyMoviesResponse()
    private val moviesId = moviesResponse[0].id
    private val tvShowsResponse = DataDummy.dataDummyTvShowsResponse()
    private val tvShowsId = tvShowsResponse[0].id

    @Test
    fun testGetAllMovies() {
        runBlocking {
            doAnswer { invocation ->
                (invocation.arguments[0] as LoadMoviesCallback)
                    .onAllMoviesReceived(moviesResponse)
                null
            }.`when`(remote).getAllMovies(any(),eq(apiKey), eq(language))
        }

        val movie = LiveDataTestUtil.getValue(catalogueRepository.getAllMovies(eq(apiKey), eq(language)))

        runBlocking {
            verify(remote).getAllMovies(any(), eq(apiKey), eq(language))
        }

        assertNotNull(movie)
        assertEquals(moviesResponse.size.toLong(), movie.size.toLong())
    }

    fun testGetByIdMovies() {}

    fun testGetAllTvShows() {}

    fun testGetByIdTvShows() {}
}