package com.ibeybeh.submission.moviecatalogue.presentation.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ibeybeh.submission.moviecatalogue.data.CatalogueRepository
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.MoviesEntity
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.TvShowEntity
import com.ibeybeh.submission.moviecatalogue.utils.DataDummyHelper
import com.ibeybeh.submission.moviecatalogue.vo.Resources
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailCatalogueViewModelTest {
    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummyHelper.generateDummyMoviesEntity()[0]
    private val movieId = dummyMovie.id
    private val dummyTvShow = DataDummyHelper.generateDummyTvShowsEntity()[0]
    private val tvShowId = dummyTvShow.id

    @get:Rule
    var instantiationException = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var movieObserver: Observer<Resources<MoviesEntity>>

    @Mock
    private lateinit var tvShowObserver: Observer<Resources<TvShowEntity>>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(catalogueRepository)
        viewModel.setSelectedMovieId(movieId)
        viewModel.setSelectedTvShowId(tvShowId)
    }

    @Test
    fun setSelectedMoviesSuccess() {
        val expected = MutableLiveData<Resources<MoviesEntity>>()
        expected.value = Resources.success(dummyMovie)

        `when`(catalogueRepository.getMoviesById(movieId)).thenReturn(expected)

        viewModel.getDetailMovies().observeForever(movieObserver)

        verify(movieObserver).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getDetailMovies().value

        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun setSelectedTvShowSuccess() {
        val expected = MutableLiveData<Resources<TvShowEntity>>()
        expected.value = Resources.success(dummyTvShow)

        `when`(catalogueRepository.getTvShowsById(tvShowId)).thenReturn(expected)

        viewModel.getDetailTvShows().observeForever(tvShowObserver)

        verify(tvShowObserver).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getDetailTvShows().value

        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun setSelectedMoviesSuccesObserver() {
        val expected = MutableLiveData<Resources<MoviesEntity>>()
        expected.value = Resources.success(dummyMovie)

        `when`(catalogueRepository.getMoviesById(movieId)).thenReturn(expected)

        viewModel.setMovieFavorite(dummyMovie)
        viewModel.getDetailMovies().observeForever(movieObserver)

        verify(movieObserver).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getDetailMovies().value

        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun setSelectedTvShowSuccesObserver() {
        val expected = MutableLiveData<Resources<TvShowEntity>>()
        expected.value = Resources.success(dummyTvShow)

        `when`(catalogueRepository.getTvShowsById(tvShowId)).thenReturn(expected)

        viewModel.setTvShowFavorite(dummyTvShow)
        viewModel.getDetailTvShows().observeForever(tvShowObserver)

        verify(tvShowObserver).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getDetailTvShows().value

        assertEquals(expectedValue, actualValue)
    }
}