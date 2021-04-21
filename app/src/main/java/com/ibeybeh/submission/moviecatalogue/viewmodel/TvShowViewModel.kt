package com.ibeybeh.submission.moviecatalogue.viewmodel

import androidx.lifecycle.ViewModel
import com.ibeybeh.submission.moviecatalogue.data.TvShowData
import com.ibeybeh.submission.moviecatalogue.utils.DataDummy

class TvShowViewModel : ViewModel() {

    private var tvShowsId: Int = 0

    fun getDataDummyListTvShows(): List<TvShowData> {
        return DataDummy.generateDummyTvShows()
    }

    fun setSelectedTvShows(id: Int) {
        this.tvShowsId = id
    }

    fun getDataDummyTvShows(): TvShowData {
        lateinit var tvShows: TvShowData
        val tvShowsList = DataDummy.generateDummyTvShows()
        for (tvShowData in tvShowsList) {
            if (tvShowData.id == tvShowsId) {
                tvShows = tvShowData
            }
        }
        return tvShows
    }
}