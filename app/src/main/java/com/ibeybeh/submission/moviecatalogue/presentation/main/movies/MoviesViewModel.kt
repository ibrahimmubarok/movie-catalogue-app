package com.ibeybeh.submission.moviecatalogue.presentation.main.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.ibeybeh.submission.moviecatalogue.data.CatalogueRepository
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.MoviesEntity
import com.ibeybeh.submission.moviecatalogue.vo.Resources

class MoviesViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getAllMovies(): LiveData<Resources<PagedList<MoviesEntity>>> = catalogueRepository.getAllMovies()
}