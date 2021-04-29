package com.ibeybeh.submission.moviecatalogue.data.source.remote

import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.MoviesData
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.TvShowData
import com.ibeybeh.submission.moviecatalogue.utils.DataDummyHelper

class RemoteDataSource private constructor(private val dataDummyHelper: DataDummyHelper) {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(dataDummyHelper: DataDummyHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                RemoteDataSource(dataDummyHelper).apply { instance = this }
            }
    }

    fun getAllMovies(): List<MoviesData> = dataDummyHelper.generateDummyMovies()

    fun getAllTvShows(): List<TvShowData> = dataDummyHelper.generateDummyTvShows()
}