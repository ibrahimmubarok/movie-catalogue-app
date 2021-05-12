package com.ibeybeh.submission.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.MoviesEntity
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.TvShowEntity
import com.ibeybeh.submission.moviecatalogue.vo.Resources

interface CatalogueDataSource {

    fun getAllMovies(): LiveData<Resources<PagedList<MoviesEntity>>>

    fun getMoviesById(moviesId: Int): LiveData<Resources<MoviesEntity>>

    fun getAllMoviesFavorite(): LiveData<PagedList<MoviesEntity>>

    fun getAllTvShows(): LiveData<Resources<PagedList<TvShowEntity>>>

    fun getTvShowsById(tvShowId: Int): LiveData<Resources<TvShowEntity>>

    fun getAllTvShowsFavorite(): LiveData<PagedList<TvShowEntity>>

    fun setFavoriteMovie(movie: MoviesEntity)

    fun setFavoriteTvShow(tvShow: TvShowEntity)

}