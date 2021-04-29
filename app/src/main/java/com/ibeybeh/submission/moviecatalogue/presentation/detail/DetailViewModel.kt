package com.ibeybeh.submission.moviecatalogue.presentation.detail

import androidx.lifecycle.ViewModel
import com.ibeybeh.submission.moviecatalogue.data.CatalogueRepository
import com.ibeybeh.submission.moviecatalogue.data.source.local.MoviesEntity
import com.ibeybeh.submission.moviecatalogue.data.source.local.TvShowEntity

class DetailViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    private var movieId: Int = 0
    private var tvShowId: Int = 0

    fun setSelectedMovieId(movieId: Int) {
        this.movieId = movieId
    }

    fun setSelectedTvShowId(tvShowId: Int) {
        this.tvShowId = tvShowId
    }

    fun getDetailMovies(): MoviesEntity = catalogueRepository.getMoviesById(movieId)

    fun getDetailTvShows(): TvShowEntity = catalogueRepository.getTvShowsById(tvShowId)
}