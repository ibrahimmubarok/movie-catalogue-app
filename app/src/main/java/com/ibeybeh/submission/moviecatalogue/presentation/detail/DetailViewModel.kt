package com.ibeybeh.submission.moviecatalogue.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ibeybeh.submission.moviecatalogue.data.CatalogueRepository
import com.ibeybeh.submission.moviecatalogue.data.source.domain.DetailMovie
import com.ibeybeh.submission.moviecatalogue.data.source.domain.DetailTvShow

class DetailViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    private var movieId: Int = 0
    private var tvShowId: Int = 0

    fun setSelectedMovieId(movieId: Int) {
        this.movieId = movieId
    }

    fun setSelectedTvShowId(tvShowId: Int) {
        this.tvShowId = tvShowId
    }

    fun getDetailMovies(apiKey: String, language: String): LiveData<DetailMovie> =
        catalogueRepository.getByIdMovies(movieId, apiKey, language)

    fun getDetailTvShow(apiKey: String, language: String): LiveData<DetailTvShow> =
        catalogueRepository.getByIdTvShows(tvShowId, apiKey, language)
}