package com.ibeybeh.submission.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.MoviesEntity
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.TvShowEntity
import com.ibeybeh.submission.moviecatalogue.data.source.local.room.CatalogueDao

class LocalDataSource private constructor(private val mCatalogueDao: CatalogueDao){

    companion object {

        private var INSTANCE: LocalDataSource? = null

        fun getInstance(catalogueDao: CatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(catalogueDao).apply {
                INSTANCE = this
            }
    }

    fun getAllMovies(): DataSource.Factory<Int, MoviesEntity> = mCatalogueDao.getAllMovies()

    fun getAllTvShows(): DataSource.Factory<Int, TvShowEntity> = mCatalogueDao.getAllTvShows()

    fun getAllFavoriteMovies(): DataSource.Factory<Int, MoviesEntity> = mCatalogueDao.getAllFavoriteMovies()

    fun getAllFavoriteTvShows(): DataSource.Factory<Int, TvShowEntity> = mCatalogueDao.getAllFavoriteTvShows()

    fun getMovieById(movieId: Int): LiveData<MoviesEntity> = mCatalogueDao.getMovieById(movieId)

    fun getTvShowById(tvShowId: Int): LiveData<TvShowEntity> = mCatalogueDao.getTvShowById(tvShowId)

    fun insertMovies(movies: List<MoviesEntity>) = mCatalogueDao.insertMovies(movies)

    fun insertTvShows(tvShows: List<TvShowEntity>) = mCatalogueDao.insertTvShows(tvShows)

    fun setFavoriteMovie(movie: MoviesEntity) {
        movie.isFavorite = !movie.isFavorite
        mCatalogueDao.updateMovie(movie)
    }

    fun setFavoriteTvShow(tvShow: TvShowEntity) {
        tvShow.isFavorite = !tvShow.isFavorite
        mCatalogueDao.updateTvShow(tvShow)
    }
}