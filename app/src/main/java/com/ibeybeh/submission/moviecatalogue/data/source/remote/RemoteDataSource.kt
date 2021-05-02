package com.ibeybeh.submission.moviecatalogue.data.source.remote

import android.util.Log
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.api.movie.MovieApiClient
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.api.tvshow.TvShowApiClient
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.model.DetailMovieData
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.model.DetailTvShowData
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.model.GeneralMoviesData
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.model.GeneralTvShowData
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.model.MoviesData
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.model.TvShowsData
import com.ibeybeh.submission.moviecatalogue.utils.EspressoIdlingResource
import com.ibeybeh.submission.moviecatalogue.utils.api.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                RemoteDataSource().apply { instance = this }
            }
    }

    fun getAllMovies(callback: LoadMoviesCallback, apiKey: String, language: String) {
        EspressoIdlingResource.increment()
        val movies: MutableList<MoviesData> = mutableListOf()

        val client = ApiConfig.buildService(MovieApiClient::class.java).getPopularMovie(apiKey, language)
        client.enqueue(object : Callback<GeneralMoviesData> {
            override fun onResponse(call: Call<GeneralMoviesData>, response: Response<GeneralMoviesData>) {
                if (response.isSuccessful) {
                    response.body()?.movieResult?.let {
                        movies.addAll(it)
                        callback.onAllMoviesReceived(movies)
                        EspressoIdlingResource.decrement()
                    }
                } else {
                    EspressoIdlingResource.decrement()
                    Log.e("MainViewModel", "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<GeneralMoviesData>, t: Throwable) {
                EspressoIdlingResource.decrement()
                Log.e("MoviesFailure", "onFailure: ${t.message.toString()}")
            }
        })
    }

    fun getByIdMovies(callback: LoadDetailMoviesCallback, movieId: Int, apiKey: String, language: String) {
        EspressoIdlingResource.increment()
        var movies: DetailMovieData

        val client = ApiConfig.buildService(MovieApiClient::class.java).getByIdMovies(movieId, apiKey, language)
        client.enqueue(object : Callback<DetailMovieData> {
            override fun onResponse(call: Call<DetailMovieData>, response: Response<DetailMovieData>) {
                if (response.isSuccessful) {
                    movies = DetailMovieData(
                        backdropPath = response.body()?.backdropPath,
                        genres = response.body()?.genres,
                        homepage = response.body()?.homepage,
                        id = response.body()?.id,
                        originalTitle = response.body()?.originalTitle,
                        overview = response.body()?.overview,
                        posterPath = response.body()?.posterPath,
                        releaseDate = response.body()?.releaseDate,
                        runtime = response.body()?.runtime,
                        title = response.body()?.title,
                        voteAverage = response.body()?.voteAverage
                    )
                    callback.onByIdMoviesReceived(movies)
                    EspressoIdlingResource.decrement()
                }else{
                    Log.e("DetailMovies", "onFailure: ${response.message()}")
                    EspressoIdlingResource.decrement()
                }
            }

            override fun onFailure(call: Call<DetailMovieData>, t: Throwable) {
                Log.e("DetailMoviesFailure", "onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getAllTvShows(callback: LoadTvShowsCallback, apiKey: String, language: String) {
        EspressoIdlingResource.increment()
        val tvShows: MutableList<TvShowsData> = mutableListOf()

        val client = ApiConfig.buildService(TvShowApiClient::class.java).getPopularTvShows(apiKey, language)
        client.enqueue(object : Callback<GeneralTvShowData> {
            override fun onResponse(call: Call<GeneralTvShowData>, response: Response<GeneralTvShowData>) {
                if (response.isSuccessful) {
                    response.body()?.results?.let {
                        tvShows.addAll(it)
                        callback.onAllTvShowsReceived(tvShows)
                    }
                    EspressoIdlingResource.decrement()
                } else {
                    Log.e("TvShowModel", "onFailure: ${response.message()}")
                    EspressoIdlingResource.decrement()
                }
            }

            override fun onFailure(call: Call<GeneralTvShowData>, t: Throwable) {
                Log.e("TvShowModelFail", "onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getByIdTvShow(callback: LoadDetailTvShowCallback, tvShowId: Int, apiKey: String, language: String) {
        EspressoIdlingResource.increment()
        var tvShow: DetailTvShowData

        val client = ApiConfig.buildService(TvShowApiClient::class.java).getByIdTvShow(tvShowId, apiKey, language)
        client.enqueue(object : Callback<DetailTvShowData> {
            override fun onResponse(call: Call<DetailTvShowData>, response: Response<DetailTvShowData>) {
                if (response.isSuccessful) {
                    tvShow = DetailTvShowData(
                        backdropPath = response.body()?.backdropPath,
                        genres = response.body()?.genres,
                        homepage = response.body()?.homepage,
                        id = response.body()?.id,
                        overview = response.body()?.overview,
                        posterPath = response.body()?.posterPath,
                        voteAverage = response.body()?.voteAverage,
                        firstAirDate = response.body()?.firstAirDate,
                        lastAirDate = response.body()?.lastAirDate,
                        name = response.body()?.name,
                        numberOfEpisodes = response.body()?.numberOfEpisodes,
                        numberOfSeasons = response.body()?.numberOfSeasons,
                    )
                    callback.onByIdTvShowReceived(tvShow)
                    EspressoIdlingResource.decrement()
                }else{
                    Log.e("DetailTvShow", "onFailure: ${response.message()}")
                    EspressoIdlingResource.decrement()
                }
            }

            override fun onFailure(call: Call<DetailTvShowData>, t: Throwable) {
                Log.e("DetailTvShowFail", "onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })
    }
}