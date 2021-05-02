package com.ibeybeh.submission.moviecatalogue.presentation.main.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ibeybeh.submission.moviecatalogue.data.CatalogueRepository
import com.ibeybeh.submission.moviecatalogue.data.source.domain.Movie

class MoviesViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getAllMovies(apiKey: String, language: String): LiveData<List<Movie>> {
        return catalogueRepository.getAllMovies(apiKey, language)
    }
}