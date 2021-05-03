package com.ibeybeh.submission.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ibeybeh.submission.moviecatalogue.data.source.domain.DetailMovie
import com.ibeybeh.submission.moviecatalogue.data.source.domain.DetailTvShow
import com.ibeybeh.submission.moviecatalogue.data.source.domain.Movie
import com.ibeybeh.submission.moviecatalogue.data.source.domain.TvShow
import com.ibeybeh.submission.moviecatalogue.data.source.domain.mapToByIdMovie
import com.ibeybeh.submission.moviecatalogue.data.source.domain.mapToByIdTvShow
import com.ibeybeh.submission.moviecatalogue.data.source.domain.mapToListMovie
import com.ibeybeh.submission.moviecatalogue.data.source.domain.mapToListTvShow
import com.ibeybeh.submission.moviecatalogue.data.source.remote.RemoteDataSource
import com.ibeybeh.submission.moviecatalogue.data.source.remote.RemoteDataSource.LoadDetailMoviesCallback
import com.ibeybeh.submission.moviecatalogue.data.source.remote.RemoteDataSource.LoadDetailTvShowCallback
import com.ibeybeh.submission.moviecatalogue.data.source.remote.RemoteDataSource.LoadMoviesCallback
import com.ibeybeh.submission.moviecatalogue.data.source.remote.RemoteDataSource.LoadTvShowsCallback
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.model.DetailMovieData
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.model.DetailTvShowData
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.model.MoviesData
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.model.TvShowsData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class CatalogueRepository private constructor(private val remoteDataSource: RemoteDataSource) : CatalogueDataSource {

    companion object {

        @Volatile
        private var instance: CatalogueRepository? = null

        fun getInstance(remoteData: RemoteDataSource): CatalogueRepository =
            instance ?: synchronized(this) {
                CatalogueRepository(remoteData).apply { instance = this }
            }
    }

    override fun getAllMovies(apiKey: String, language: String): LiveData<List<Movie>> {
        val moviesResults = MutableLiveData<List<Movie>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getAllMovies(object : LoadMoviesCallback {
                override fun onAllMoviesReceived(moviesResponse: MutableList<MoviesData>) {
                    val movieMap = moviesResponse.map {
                        it.mapToListMovie()
                    }
                    moviesResults.postValue(movieMap)
                }
            }, apiKey = apiKey, language = language)
        }
        return moviesResults
    }

    override fun getByIdMovies(id: Int, apiKey: String, language: String): LiveData<DetailMovie> {
        val moviesResults = MutableLiveData<DetailMovie>()
        remoteDataSource.getByIdMovies(object : LoadDetailMoviesCallback {
            override fun onByIdMoviesReceived(detailMovieResponse: DetailMovieData) {
                moviesResults.postValue(detailMovieResponse.mapToByIdMovie())
            }
        }, apiKey = apiKey, language = language, movieId = id)
        return moviesResults
    }

    override fun getAllTvShows(apiKey: String, language: String): LiveData<List<TvShow>> {
        val tvShowsResults = MutableLiveData<List<TvShow>>()
        remoteDataSource.getAllTvShows(object: LoadTvShowsCallback {
            override fun onAllTvShowsReceived(tvShowResponse: MutableList<TvShowsData>) {
                val tvShows = tvShowResponse.map {
                    it.mapToListTvShow()
                }
                tvShowsResults.postValue(tvShows)
            }
        }, apiKey = apiKey, language = language)
        return tvShowsResults
    }

    override fun getByIdTvShows(id: Int, apiKey: String, language: String): LiveData<DetailTvShow> {
        val tvShowResults = MutableLiveData<DetailTvShow>()
        remoteDataSource.getByIdTvShow(object : LoadDetailTvShowCallback {
            override fun onByIdTvShowReceived(detailTvShowResponse: DetailTvShowData) {
                tvShowResults.postValue(detailTvShowResponse.mapToByIdTvShow())
            }
        }, tvShowId = id, apiKey = apiKey, language = language )
        return tvShowResults
    }
}