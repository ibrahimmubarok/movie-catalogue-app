package com.ibeybeh.submission.moviecatalogue.presentation.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.ibeybeh.submission.moviecatalogue.data.CatalogueRepository
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.MoviesEntity
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.TvShowEntity

class FavoriteViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getAllMoviesFavorite(): LiveData<PagedList<MoviesEntity>> = catalogueRepository.getAllMoviesFavorite()

    fun getAllTvShowsFavorite(): LiveData<PagedList<TvShowEntity>> = catalogueRepository.getAllTvShowsFavorite()

    fun setMovieFavorite(moviesEntity: MoviesEntity) {
        catalogueRepository.setFavoriteMovie(moviesEntity)
    }

    fun setTvShowFavorite(tvShowEntity: TvShowEntity) {
        catalogueRepository.setFavoriteTvShow(tvShowEntity)
    }
}