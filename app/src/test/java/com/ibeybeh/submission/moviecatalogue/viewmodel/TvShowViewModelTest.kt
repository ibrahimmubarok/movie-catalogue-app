package com.ibeybeh.submission.moviecatalogue.viewmodel

import com.ibeybeh.submission.moviecatalogue.utils.DataDummyHelper
import junit.framework.TestCase
import org.junit.*

class TvShowViewModelTest : TestCase() {

    private lateinit var tvShowViewModel: TvShowViewModel
    private val listTvShows = DataDummyHelper.generateDummyTvShows()[9]
    private val id = listTvShows.id

    @Before
    override fun setUp() {
        tvShowViewModel = TvShowViewModel()
        if (id != null) {
            tvShowViewModel.setSelectedTvShows(id)
        }
    }

    @Test
    fun testGetDataDummyListTvShows() {
        val tvShowList = tvShowViewModel.getDataDummyListTvShows()
        assertNotNull(tvShowList)
        assertEquals(10, tvShowList.size)
    }

    @Test
    fun testGetDataDummyTvShows() {
        listTvShows.id?.let { id ->
            tvShowViewModel.setSelectedTvShows(id)
        }
        val tvShows = tvShowViewModel.getDataDummyTvShows()
        assertNotNull(tvShows)
        assertEquals(listTvShows.id, tvShows.id)
        assertEquals(listTvShows.photo, tvShows.photo)
        assertEquals(listTvShows.backdropPath, tvShows.backdropPath)
        assertEquals(listTvShows.genre, tvShows.genre)
        assertEquals(listTvShows.name, tvShows.name)
        assertEquals(listTvShows.overview, tvShows.overview)
        assertEquals(listTvShows.firstAirDate, tvShows.firstAirDate)
        assertEquals(listTvShows.rating, tvShows.rating)
        assertEquals(listTvShows.homepage, tvShows.homepage)
        assertEquals(listTvShows.episodes, tvShows.episodes)
        assertEquals(listTvShows.seasons, tvShows.seasons)
    }
}