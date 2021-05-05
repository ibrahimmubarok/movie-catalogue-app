package com.ibeybeh.submission.moviecatalogue.di

import android.content.Context
import com.ibeybeh.submission.moviecatalogue.data.CatalogueRepository
import com.ibeybeh.submission.moviecatalogue.data.source.remote.RemoteDataSource
import com.ibeybeh.submission.moviecatalogue.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): CatalogueRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return CatalogueRepository.getInstance(remoteDataSource)
    }
}