package com.ibeybeh.submission.moviecatalogue.data.source.remote

import android.os.Looper
import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    fun getAllMovies(): LiveData<ApiResponse<List<MoviesData>>> {
        EspressoIdlingResources.increment()
        val resultMovies = MutableLiveData<ApiResponse<List<MoviesData>>>()
        handler.postDelayed({
            resultMovies.value = ApiResponse.success(jsonHelper.loadMovies())
            EspressoIdlingResources.decrement()
        }, LATENCY_IN_MILLIS)
        return resultMovies
    }

    fun getByIdMovie(movieId: Int): LiveData<ApiResponse<MoviesData>> {
        EspressoIdlingResources.increment()
        val resultMovies = MutableLiveData<ApiResponse<MoviesData>>()
        handler.postDelayed({
            resultMovies.value = ApiResponse.success(jsonHelper.loadByIdMovies(movieId))
            EspressoIdlingResources.decrement()
        }, LATENCY_IN_MILLIS)
        return resultMovies
    }

    fun getAllTvShows(): LiveData<ApiResponse<List<TvShowData>>> {
        EspressoIdlingResources.increment()
        val resultTvShows = MutableLiveData<ApiResponse<List<TvShowData>>>()
        handler.postDelayed({
            resultTvShows.value = ApiResponse.success(jsonHelper.loadTvShow())
            EspressoIdlingResources.decrement()
        }, LATENCY_IN_MILLIS)
        return resultTvShows
    }

    fun getByIdTvShow(tvShowId: Int): LiveData<ApiResponse<TvShowData>> {
        EspressoIdlingResources.increment()
        val resultTvShows = MutableLiveData<ApiResponse<TvShowData>>()
        handler.postDelayed({
            resultTvShows.value = ApiResponse.success(jsonHelper.loadByIdTvShow(tvShowId))
            EspressoIdlingResources.decrement()
        }, LATENCY_IN_MILLIS)
        return resultTvShows
    }
}