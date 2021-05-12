package com.ibeybeh.submission.moviecatalogue.presentation.main.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.ibeybeh.submission.moviecatalogue.data.CatalogueRepository
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.TvShowEntity
import com.ibeybeh.submission.moviecatalogue.vo.Resources

class TvShowsViewModel(private val catalogueRepository: CatalogueRepository): ViewModel() {

    fun getAllTvShows(): LiveData<Resources<PagedList<TvShowEntity>>> = catalogueRepository.getAllTvShows()
}