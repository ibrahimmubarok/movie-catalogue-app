package com.ibeybeh.submission.moviecatalogue.data

import androidx.lifecycle.LiveData
import com.ibeybeh.submission.moviecatalogue.data.source.domain.DetailMovie
import com.ibeybeh.submission.moviecatalogue.data.source.domain.DetailTvShow
import com.ibeybeh.submission.moviecatalogue.data.source.domain.Movie
import com.ibeybeh.submission.moviecatalogue.data.source.domain.TvShow

interface CatalogueDataSource {

    fun getAllMovies(apiKey: String, language: String): LiveData<List<Movie>>
    fun getByIdMovies(id: Int, apiKey: String, language: String): LiveData<DetailMovie>
    fun getAllTvShows(apiKey: String, language: String): LiveData<List<TvShow>>
    fun getByIdTvShows(id: Int, apiKey: String, language: String): LiveData<DetailTvShow>
}