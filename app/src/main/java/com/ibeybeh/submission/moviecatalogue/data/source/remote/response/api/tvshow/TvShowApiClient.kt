package com.ibeybeh.submission.moviecatalogue.data.source.remote.response.api.tvshow

import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.model.DetailTvShowData
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.model.GeneralTvShowData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvShowApiClient {
    @GET("tv/popular")
    fun getPopularTvShows(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Call<GeneralTvShowData>

    @GET("tv/{tv_id}")
    fun getByIdTvShow(
        @Path("tv_id") tvShowId: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Call<DetailTvShowData>
}