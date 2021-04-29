package com.ibeybeh.submission.moviecatalogue.data

import com.ibeybeh.submission.moviecatalogue.data.source.local.MoviesEntity
import com.ibeybeh.submission.moviecatalogue.data.source.local.TvShowEntity

interface CatalogueDataSource {

    fun getAllMovies(): List<MoviesEntity>

    fun getMoviesById(moviesId: Int): MoviesEntity

    fun getAllTvShows(): List<TvShowEntity>

    fun getTvShowsById(tvShowId: Int): TvShowEntity
}