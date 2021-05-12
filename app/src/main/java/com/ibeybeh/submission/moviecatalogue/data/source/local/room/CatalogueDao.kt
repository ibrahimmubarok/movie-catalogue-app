package com.ibeybeh.submission.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.MoviesEntity
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.TvShowEntity

@Dao
interface CatalogueDao {

    @Query("SELECT * FROM tbl_favorite_movie")
    fun getAllMovies(): DataSource.Factory<Int, MoviesEntity>

    @Query("SELECT * FROM tbl_favorite_tv_show")
    fun getAllTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM tbl_favorite_movie WHERE is_favorite = 1")
    fun getAllFavoriteMovies(): DataSource.Factory<Int, MoviesEntity>

    @Query("SELECT * FROM tbl_favorite_tv_show WHERE is_favorite = 1")
    fun getAllFavoriteTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM tbl_favorite_movie WHERE id = :movieId")
    fun getMovieById(movieId: Int): LiveData<MoviesEntity>

    @Query("SELECT * FROM tbl_favorite_tv_show WHERE id = :tvShowId")
    fun getTvShowById(tvShowId: Int): LiveData<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = MoviesEntity::class)
    fun insertMovies(movies: List<MoviesEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = TvShowEntity::class)
    fun insertTvShows(tvShows: List<TvShowEntity>)

    @Update(entity = MoviesEntity::class)
    fun updateMovie(movie: MoviesEntity)

    @Update(entity = TvShowEntity::class)
    fun updateTvShow(tvShow: TvShowEntity)
}