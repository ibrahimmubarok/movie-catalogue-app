package com.ibeybeh.submission.moviecatalogue.viewmodel

import androidx.lifecycle.ViewModel
import com.ibeybeh.submission.moviecatalogue.data.MoviesData

class MainViewModel : ViewModel() {

    fun getDataDummyListMovies(data: List<MoviesData>) : List<MoviesData> {
        return data
    }

    fun getDataDummyMovies(data: MoviesData) : MoviesData {
        return data
    }
}