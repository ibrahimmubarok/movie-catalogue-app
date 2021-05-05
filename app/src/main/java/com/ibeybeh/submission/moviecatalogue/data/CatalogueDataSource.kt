package com.ibeybeh.submission.moviecatalogue.data

import androidx.lifecycle.LiveData
import com.ibeybeh.submission.moviecatalogue.data.source.local.MoviesEntity
import com.ibeybeh.submission.moviecatalogue.data.source.local.TvShowEntity

interface CatalogueDataSource {

    fun getAllMovies(): LiveData<List<MoviesEntity>>

    fun getMoviesById(moviesId: Int): LiveData<MoviesEntity>

    fun getAllTvShows(): LiveData<List<TvShowEntity>>

    fun getTvShowsById(tvShowId: Int): LiveData<TvShowEntity>
}