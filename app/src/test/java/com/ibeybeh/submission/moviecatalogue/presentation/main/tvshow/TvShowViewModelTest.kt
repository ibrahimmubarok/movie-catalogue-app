package com.ibeybeh.submission.moviecatalogue.presentation.main.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ibeybeh.submission.moviecatalogue.data.CatalogueRepository
import com.ibeybeh.submission.moviecatalogue.data.source.local.TvShowEntity
import com.ibeybeh.submission.moviecatalogue.presentation.main.tvshows.TvShowsViewModel
import com.ibeybeh.submission.moviecatalogue.utils.DataDummyHelper
import org.junit.*
import org.junit.runner.*
import org.mockito.*
import org.mockito.junit.*

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var tvShowObserver: Observer<List<TvShowEntity>>

    @Before
    fun setUp() {
        viewModel = TvShowsViewModel(catalogueRepository)
    }


    @Test
    fun getTvShows() {
        val dummyTvShow = DataDummyHelper.generateDummyTvShowsEntity()
        val tvShows = MutableLiveData<List<TvShowEntity>>()
        tvShows.value = dummyTvShow

        Mockito.`when`(catalogueRepository.getAllTvShows()).thenReturn(tvShows)
        val tvShowEntities = viewModel.getAllTvShows().value
        Mockito.verify(catalogueRepository).getAllTvShows()
        Assert.assertNotNull(tvShowEntities)
        Assert.assertEquals(10, tvShowEntities?.size)

        viewModel.getAllTvShows().observeForever(tvShowObserver)
        Mockito.verify(tvShowObserver).onChanged(dummyTvShow)
    }
}