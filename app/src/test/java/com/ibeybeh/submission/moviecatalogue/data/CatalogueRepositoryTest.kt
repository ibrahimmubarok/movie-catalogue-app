package com.ibeybeh.submission.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.ibeybeh.submission.moviecatalogue.data.source.local.LocalDataSource
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.MoviesEntity
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.TvShowEntity
import com.ibeybeh.submission.moviecatalogue.data.source.remote.RemoteDataSource
import com.ibeybeh.submission.moviecatalogue.utils.AppExecutors
import com.ibeybeh.submission.moviecatalogue.utils.DataDummyHelper
import com.ibeybeh.submission.moviecatalogue.utils.LiveDataTestUtil
import com.ibeybeh.submission.moviecatalogue.utils.PagedListUtil
import com.ibeybeh.submission.moviecatalogue.vo.Resources
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertEquals
import com.nhaarman.mockitokotlin2.verify
import org.mockito.Mockito.*

class CatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val catalogueRepository = FakeCatalogueRepository(remote, local, appExecutors)

    private val moviesResponse = DataDummyHelper.generateDummyMovies()
    private val moviesData = DataDummyHelper.generateDummyMoviesEntity()[0]
    private val moviesId = moviesResponse[0].id
    private val tvShowResponse = DataDummyHelper.generateDummyTvShows()
    private val tvShowData = DataDummyHelper.generateDummyTvShowsEntity()[0]
    private val tvShowId = tvShowResponse[0].id

    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MoviesEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        catalogueRepository.getAllMovies()

        val moviesEntity = Resources.success(PagedListUtil.mockPagedList(DataDummyHelper.generateDummyMovies()))
        verify(local).getAllMovies()
        assertNotNull(moviesEntity.data)
        assertEquals(moviesResponse.size.toLong(), moviesEntity.data?.size?.toLong())
    }

    @Test
    fun getAllTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getAllTvShows()).thenReturn(dataSourceFactory)
        catalogueRepository.getAllTvShows()

        val tvShowEntity = Resources.success(PagedListUtil.mockPagedList(DataDummyHelper.generateDummyTvShows()))
        verify(local).getAllTvShows()
        assertNotNull(tvShowEntity.data)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntity.data?.size?.toLong())
    }

    @Test
    fun getByIdMovies() {
        val dummyEntity = MutableLiveData<MoviesEntity>()
        dummyEntity.value = moviesData
        `when`(local.getMovieById(moviesId)).thenReturn(dummyEntity)

        val movie = LiveDataTestUtil.getValue(catalogueRepository.getMoviesById(moviesId))
        verify(local).getMovieById(moviesId)
        assertNotNull(movie)
        assertEquals(moviesResponse[0].title, movie.data?.title)
    }

    @Test
    fun getByIdTvShows() {
        val dummyEntity = MutableLiveData<TvShowEntity>()
        dummyEntity.value = tvShowData
        `when`(local.getTvShowById(tvShowId)).thenReturn(dummyEntity)

        val tvShow = LiveDataTestUtil.getValue(catalogueRepository.getTvShowsById(tvShowId))
        verify(local).getTvShowById(tvShowId)
        assertNotNull(tvShow)
        assertEquals(tvShowResponse[0].name, tvShow.data?.name)
    }

    @Test
    fun getFavoriteMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MoviesEntity>
        `when`(local.getAllFavoriteMovies()).thenReturn(dataSourceFactory)
        catalogueRepository.getAllMoviesFavorite()

        val movies = Resources.success(PagedListUtil.mockPagedList(DataDummyHelper.generateDummyMovies()))
        verify(local).getAllFavoriteMovies()
        assertNotNull(movies)
        assertEquals(moviesResponse.size.toLong(), movies.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getAllFavoriteTvShows()).thenReturn(dataSourceFactory)
        catalogueRepository.getAllTvShowsFavorite()

        val tvShow = Resources.success(PagedListUtil.mockPagedList(DataDummyHelper.generateDummyTvShows()))
        verify(local).getAllFavoriteTvShows()
        assertNotNull(tvShow)
        assertEquals(tvShowResponse.size.toLong(), tvShow.data?.size?.toLong())
    }

    @Test
    fun setFavoriteMovie() {
        doNothing().`when`(local).setFavoriteMovie(moviesData)
        catalogueRepository.setFavoriteMovie(moviesData)

        verify(local, times(1)).setFavoriteMovie(moviesData)
    }

    @Test
    fun setFavoriteTvShow() {
        doNothing().`when`(local).setFavoriteTvShow(tvShowData)
        catalogueRepository.setFavoriteTvShow(tvShowData)

        verify(local, times(1)).setFavoriteTvShow(tvShowData)
    }
}