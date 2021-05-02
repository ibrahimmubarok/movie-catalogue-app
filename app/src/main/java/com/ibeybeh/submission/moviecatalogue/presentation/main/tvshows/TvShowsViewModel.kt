package com.ibeybeh.submission.moviecatalogue.presentation.main.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ibeybeh.submission.moviecatalogue.data.CatalogueRepository
import com.ibeybeh.submission.moviecatalogue.data.source.domain.TvShow

class TvShowsViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getAllTvShows(apiKey: String, language: String): LiveData<List<TvShow>> {
        return catalogueRepository.getAllTvShows(apiKey, language)
    }
}