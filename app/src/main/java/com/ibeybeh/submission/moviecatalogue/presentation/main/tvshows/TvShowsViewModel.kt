package com.ibeybeh.submission.moviecatalogue.presentation.main.tvshows

import androidx.lifecycle.ViewModel
import com.ibeybeh.submission.moviecatalogue.data.CatalogueRepository
import com.ibeybeh.submission.moviecatalogue.data.source.local.TvShowEntity

class TvShowsViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {

    fun getAllTvShows(): List<TvShowEntity> = catalogueRepository.getAllTvShows()
}