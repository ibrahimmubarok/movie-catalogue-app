package com.ibeybeh.submission.moviecatalogue.data.source.remote.response.api.movie

import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.model.DetailMovieData
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.model.GenreData
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.model.GeneralMoviesData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiClient {

    @GET("movie/popular")
    fun getPopularMovie(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Call<GeneralMoviesData>

    @GET("movie/{movie_id}")
    fun getByIdMovies(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Call<DetailMovieData>
}