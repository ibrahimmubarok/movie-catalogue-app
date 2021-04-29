package com.ibeybeh.submission.moviecatalogue.viewmodel

import androidx.lifecycle.ViewModel
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.MoviesData
import com.ibeybeh.submission.moviecatalogue.utils.DataDummyHelper

class MoviesViewModel : ViewModel() {

    private var moviesId: Int = 0

    fun getDataDummyListMovies() : List<MoviesData> {
        return DataDummyHelper.generateDummyMovies()
    }

    fun setSelectedMovies(id: Int) {
        this.moviesId = id
    }

    fun getDataDummyMovies() : MoviesData {
        lateinit var movies: MoviesData
        val moviesList = DataDummyHelper.generateDummyMovies()
        for (moviesData in moviesList) {
            if (moviesData.id == moviesId) {
                movies = moviesData
            }
        }
        return movies
    }
}