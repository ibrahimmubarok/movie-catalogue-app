package com.ibeybeh.submission.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.ibeybeh.submission.moviecatalogue.data.source.local.LocalDataSource
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.MoviesEntity
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.TvShowEntity
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.mapToMoviesEntity
import com.ibeybeh.submission.moviecatalogue.data.source.local.entity.mapToTvShowEntity
import com.ibeybeh.submission.moviecatalogue.data.source.remote.ApiResponse
import com.ibeybeh.submission.moviecatalogue.data.source.remote.RemoteDataSource
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.MoviesData
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.TvShowData
import com.ibeybeh.submission.moviecatalogue.utils.AppExecutors
import com.ibeybeh.submission.moviecatalogue.vo.Resources

class FakeCatalogueRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : CatalogueDataSource {

    override fun getAllMovies(): LiveData<Resources<PagedList<MoviesEntity>>> {
        return object : NetworkBoundResource<PagedList<MoviesEntity>, List<MoviesData>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MoviesEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MoviesEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<MoviesData>>> {
                return remoteDataSource.getAllMovies()
            }

            override fun saveCallResult(data: List<MoviesData>) {
                val movies = data.map {
                    it.mapToMoviesEntity()
                }
                localDataSource.insertMovies(movies)
            }
        }.asLiveData()
    }

    override fun getMoviesById(moviesId: Int): LiveData<Resources<MoviesEntity>> {
        return object : NetworkBoundResource<MoviesEntity, MoviesData>(appExecutors) {
            override fun loadFromDB(): LiveData<MoviesEntity> {
                return localDataSource.getMovieById(moviesId)
            }

            override fun shouldFetch(data: MoviesEntity?): Boolean = false

            override fun createCall(): LiveData<ApiResponse<MoviesData>> {
                return remoteDataSource.getByIdMovie(moviesId)
            }

            override fun saveCallResult(data: MoviesData) {
            }
        }.asLiveData()
    }

    override fun getAllMoviesFavorite(): LiveData<PagedList<MoviesEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getAllFavoriteMovies(), config).build()
    }

    override fun getAllTvShows(): LiveData<Resources<PagedList<TvShowEntity>>> {
        return object : NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowData>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<TvShowData>>> {
                return remoteDataSource.getAllTvShows()
            }

            override fun saveCallResult(data: List<TvShowData>) {
                val tvShow = data.map {
                    it.mapToTvShowEntity()
                }
                localDataSource.insertTvShows(tvShow)
            }
        }.asLiveData()
    }

    override fun getTvShowsById(tvShowId: Int): LiveData<Resources<TvShowEntity>> {
        return object : NetworkBoundResource<TvShowEntity, TvShowData>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShowEntity> {
                return localDataSource.getTvShowById(tvShowId)
            }

            override fun shouldFetch(data: TvShowEntity?): Boolean = false

            override fun createCall(): LiveData<ApiResponse<TvShowData>> {
                return remoteDataSource.getByIdTvShow(tvShowId)
            }

            override fun saveCallResult(data: TvShowData) {
            }
        }.asLiveData()
    }

    override fun getAllTvShowsFavorite(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getAllFavoriteTvShows(), config).build()
    }

    override fun setFavoriteMovie(movie: MoviesEntity) {
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteMovie(movie)
        }
    }

    override fun setFavoriteTvShow(tvShow: TvShowEntity) {
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteTvShow(tvShow)
        }
    }
}