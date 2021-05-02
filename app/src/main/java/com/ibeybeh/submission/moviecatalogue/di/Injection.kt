package com.ibeybeh.submission.moviecatalogue.di

import android.content.Context
import com.ibeybeh.submission.moviecatalogue.data.CatalogueRepository
import com.ibeybeh.submission.moviecatalogue.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): CatalogueRepository {

        val remoteDataSource = RemoteDataSource.getInstance()

        return CatalogueRepository.getInstance(remoteDataSource)
    }
}