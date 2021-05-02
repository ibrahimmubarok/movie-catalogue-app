package com.ibeybeh.submission.moviecatalogue.data.source.remote

import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.model.DetailMovieData
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.model.DetailTvShowData
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.model.MoviesData
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.model.TvShowsData

interface LoadMoviesCallback {
    fun onAllMoviesReceived(moviesResponse: MutableList<MoviesData>)
}

interface LoadDetailMoviesCallback {
    fun onByIdMoviesReceived(detailMovieResponse: DetailMovieData)
}

interface LoadTvShowsCallback {
    fun onAllTvShowsReceived(tvShowResponse: MutableList<TvShowsData>)
}

interface LoadDetailTvShowCallback {
    fun onByIdTvShowReceived(detailTvShowResponse: DetailTvShowData)
}
