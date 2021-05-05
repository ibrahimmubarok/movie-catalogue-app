package com.ibeybeh.submission.moviecatalogue.presentation.main.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ibeybeh.submission.moviecatalogue.data.CatalogueRepository
import com.ibeybeh.submission.moviecatalogue.data.source.local.MoviesEntity

class MoviesViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getAllMovies(): LiveData<List<MoviesEntity>> = catalogueRepository.getAllMovies()
}