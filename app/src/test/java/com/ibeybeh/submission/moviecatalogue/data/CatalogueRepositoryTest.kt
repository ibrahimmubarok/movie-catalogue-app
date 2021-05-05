package com.ibeybeh.submission.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ibeybeh.submission.moviecatalogue.data.source.remote.RemoteDataSource
import com.ibeybeh.submission.moviecatalogue.utils.DataDummyHelper
import com.ibeybeh.submission.moviecatalogue.utils.LiveDataTestUtil
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertEquals
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.mockito.Mockito.*

class CatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val catalogueRepository = FakeCatalogueRepository(remote)

    private val moviesResponse = DataDummyHelper.generateDummyMovies()
    private val moviesData = DataDummyHelper.generateDummyMovies()[0]
    private val moviesId = moviesResponse[0].id
    private val tvShowResponse = DataDummyHelper.generateDummyTvShows()
    private val tvShowData = DataDummyHelper.generateDummyTvShows()[0]
    private val tvShowId = tvShowResponse[0].id

    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(moviesResponse)
            null
        }.`when`(remote).getAllMovies(any())

        val moviesEntities = LiveDataTestUtil.getValue(catalogueRepository.getAllMovies())

        verify(remote).getAllMovies(any())
        assertNotNull(moviesEntities)
        assertEquals(moviesResponse.size.toLong(), moviesEntities.size.toLong())
    }

    @Test
    fun getAllTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowsCallback)
                .onAllTvShowsReceived(tvShowResponse)
            null
        }.`when`(remote).getAllTvShows(any())

        val tvShowEntities = LiveDataTestUtil.getValue(catalogueRepository.getAllTvShows())

        verify(remote).getAllTvShows(any())
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getByIdMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesByIdCallback)
                .onByIdMovieReceived(moviesData)
            null
        }.`when`(remote).getByIdMovie(any(), eq(moviesId))

        val data = LiveDataTestUtil.getValue(catalogueRepository.getMoviesById(moviesId))

        verify(remote).getByIdMovie(any(), eq(moviesId))

        assertNotNull(data)
        assertEquals(moviesData.id, data.id)
    }

    @Test
    fun getByIdTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowsByIdCallback)
                .onByIdTvShowReceived(tvShowData)
            null
        }.`when`(remote).getByIdTvShow(any(), eq(tvShowId))

        val data = LiveDataTestUtil.getValue(catalogueRepository.getTvShowsById(tvShowId))

        verify(remote).getByIdTvShow(any(), eq(tvShowId))

        assertNotNull(data)
        assertEquals(tvShowData.id, data.id)
    }
}