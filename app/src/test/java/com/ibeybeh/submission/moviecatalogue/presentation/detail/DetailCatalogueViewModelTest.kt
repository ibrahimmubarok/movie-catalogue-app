package com.ibeybeh.submission.moviecatalogue.presentation.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ibeybeh.submission.moviecatalogue.data.CatalogueRepository
import com.ibeybeh.submission.moviecatalogue.data.source.local.MoviesEntity
import com.ibeybeh.submission.moviecatalogue.data.source.local.TvShowEntity
import com.ibeybeh.submission.moviecatalogue.utils.DataDummyHelper
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
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
    private lateinit var movieObserver: Observer<MoviesEntity>

    @Mock
    private lateinit var tvShowObserver: Observer<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(catalogueRepository)
        viewModel.setSelectedMovieId(movieId)
        viewModel.setSelectedTvShowId(tvShowId)
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<MoviesEntity>()
        movie.value = dummyMovie

        `when`(catalogueRepository.getMoviesById(movieId)).thenReturn(movie)

        val movieEntity = viewModel.getDetailMovies().value as MoviesEntity

        verify(catalogueRepository).getMoviesById(movieId)

        assertNotNull(movieEntity)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.backdropPath, movieEntity.backdropPath)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.homepage, movieEntity.homepage)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.posterPath, movieEntity.posterPath)
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyMovie.runtime, movieEntity.runtime)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.voteAverage, movieEntity.voteAverage)

        viewModel.getDetailMovies().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }
    
    @Test
    fun getTvShow() {
        val tvShow = MutableLiveData<TvShowEntity>()
        tvShow.value = dummyTvShow

        `when`(catalogueRepository.getTvShowsById(tvShowId)).thenReturn(tvShow)

        val tvShowEntity = viewModel.getDetailTvShows().value as TvShowEntity

        verify(catalogueRepository).getTvShowsById(tvShowId)
        assertNotNull(tvShow)
        assertEquals(dummyTvShow.id, tvShowEntity.id)
        assertEquals(dummyTvShow.voteAverage, tvShowEntity.voteAverage)
        assertEquals(dummyTvShow.numberOfSeasons, tvShowEntity.numberOfSeasons)
        assertEquals(dummyTvShow.numberOfEpisodes, tvShowEntity.numberOfEpisodes)
        assertEquals(dummyTvShow.name, tvShowEntity.name)
        assertEquals(dummyTvShow.homepage, tvShowEntity.homepage)
        assertEquals(dummyTvShow.genre, tvShowEntity.genre)
        assertEquals(dummyTvShow.firstAirDate, tvShowEntity.firstAirDate)
        assertEquals(dummyTvShow.backdropPath, tvShowEntity.backdropPath)
        assertEquals(dummyTvShow.overview, tvShowEntity.overview)

        viewModel.getDetailTvShows().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)
    }
}