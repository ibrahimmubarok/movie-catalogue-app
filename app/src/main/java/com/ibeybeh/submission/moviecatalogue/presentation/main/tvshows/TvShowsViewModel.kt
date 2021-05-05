package com.ibeybeh.submission.moviecatalogue.presentation.main.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ibeybeh.submission.moviecatalogue.data.CatalogueRepository
import com.ibeybeh.submission.moviecatalogue.data.source.local.TvShowEntity

class TvShowsViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {

    fun getAllTvShows(): LiveData<List<TvShowEntity>> = catalogueRepository.getAllTvShows()
}