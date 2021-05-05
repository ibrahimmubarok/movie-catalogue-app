package com.ibeybeh.submission.moviecatalogue.data.source.remote

import android.os.Looper
import android.os.Handler
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.MoviesData
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.TvShowData
import com.ibeybeh.submission.moviecatalogue.utils.EspressoIdlingResources
import com.ibeybeh.submission.moviecatalogue.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllMovies(callback: LoadMoviesCallback) {
        EspressoIdlingResources.increment()
        handler.postDelayed({
            callback.onAllMoviesReceived(jsonHelper.loadMovies())
            EspressoIdlingResources.decrement()
        }, LATENCY_IN_MILLIS)
    }

    fun getByIdMovie(callback: LoadMoviesByIdCallback, movieId: Int) {
        EspressoIdlingResources.increment()
        handler.postDelayed({
            callback.onByIdMovieReceived(jsonHelper.loadByIdMovies(movieId))
            EspressoIdlingResources.decrement()
        }, LATENCY_IN_MILLIS)
    }

    fun getAllTvShows(callback: LoadTvShowsCallback) {
        EspressoIdlingResources.increment()
        handler.postDelayed({
            callback.onAllTvShowsReceived(jsonHelper.loadTvShow())
            EspressoIdlingResources.decrement()
        }, LATENCY_IN_MILLIS)
    }

    fun getByIdTvShow(callback: LoadTvShowsByIdCallback, tvShowId: Int) {
        EspressoIdlingResources.increment()
        handler.postDelayed({
            callback.onByIdTvShowReceived(jsonHelper.loadByIdTvShow(tvShowId))
            EspressoIdlingResources.decrement()
        }, LATENCY_IN_MILLIS)
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(moviesResponse: List<MoviesData>)
    }

    interface LoadTvShowsCallback {
        fun onAllTvShowsReceived(tvShowsResponse: List<TvShowData>)
    }

    interface LoadMoviesByIdCallback {
        fun onByIdMovieReceived(moviesResponse: MoviesData)
    }

    interface LoadTvShowsByIdCallback {
        fun onByIdTvShowReceived(tvShowsResponse: TvShowData)
    }
}