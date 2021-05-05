package com.ibeybeh.submission.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ibeybeh.submission.moviecatalogue.data.source.local.MoviesEntity
import com.ibeybeh.submission.moviecatalogue.data.source.local.TvShowEntity
import com.ibeybeh.submission.moviecatalogue.data.source.local.mapToMoviesEntity
import com.ibeybeh.submission.moviecatalogue.data.source.local.mapToTvShowEntity
import com.ibeybeh.submission.moviecatalogue.data.source.remote.RemoteDataSource
import com.ibeybeh.submission.moviecatalogue.data.source.remote.RemoteDataSource.LoadMoviesByIdCallback
import com.ibeybeh.submission.moviecatalogue.data.source.remote.RemoteDataSource.LoadMoviesCallback
import com.ibeybeh.submission.moviecatalogue.data.source.remote.RemoteDataSource.LoadTvShowsByIdCallback
import com.ibeybeh.submission.moviecatalogue.data.source.remote.RemoteDataSource.LoadTvShowsCallback
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.MoviesData
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.TvShowData

class FakeCatalogueRepository(private val remoteDataSource: RemoteDataSource) : CatalogueDataSource{

    override fun getAllMovies(): LiveData<List<MoviesEntity>> {
        val movieResults = MutableLiveData<List<MoviesEntity>>()
        remoteDataSource.getAllMovies(object : LoadMoviesCallback {
            override fun onAllMoviesReceived(moviesResponse: List<MoviesData>) {
                val movies = moviesResponse.map {
                    it.mapToMoviesEntity()
                }
                movieResults.postValue(movies)
            }
        })
        return movieResults
    }

    override fun getMoviesById(moviesId: Int): LiveData<MoviesEntity> {
        val movieResults = MutableLiveData<MoviesEntity>()
        remoteDataSource.getByIdMovie(object : LoadMoviesByIdCallback {
            override fun onByIdMovieReceived(moviesResponse: MoviesData) {
                val movies = moviesResponse.mapToMoviesEntity()
                movieResults.postValue(movies)
            }
        }, movieId = moviesId)

        return movieResults
    }

    override fun getAllTvShows(): LiveData<List<TvShowEntity>> {
        val tvShowResult = MutableLiveData<List<TvShowEntity>>()
        remoteDataSource.getAllTvShows(object : LoadTvShowsCallback {
            override fun onAllTvShowsReceived(tvShowsResponse: List<TvShowData>) {
                val tvShows = tvShowsResponse.map {
                    it.mapToTvShowEntity()
                }
                tvShowResult.postValue(tvShows)
            }
        })
        return tvShowResult
    }

    override fun getTvShowsById(tvShowId: Int): LiveData<TvShowEntity> {
        val tvShowResult = MutableLiveData<TvShowEntity>()
        remoteDataSource.getByIdTvShow(object : LoadTvShowsByIdCallback {
            override fun onByIdTvShowReceived(tvShowsResponse: TvShowData) {
                val tvShow = tvShowsResponse.mapToTvShowEntity()
                tvShowResult.postValue(tvShow)
            }
        }, tvShowId = tvShowId)

        return tvShowResult
    }
}