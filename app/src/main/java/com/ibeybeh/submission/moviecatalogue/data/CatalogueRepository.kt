package com.ibeybeh.submission.moviecatalogue.data

import com.ibeybeh.submission.moviecatalogue.data.source.local.MoviesEntity
import com.ibeybeh.submission.moviecatalogue.data.source.local.TvShowEntity
import com.ibeybeh.submission.moviecatalogue.data.source.remote.RemoteDataSource
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.MoviesData
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.TvShowData

class CatalogueRepository private constructor(private val remoteDataSource: RemoteDataSource) : CatalogueDataSource {

    companion object {
        @Volatile
        private var instance: CatalogueRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): CatalogueRepository =
            instance ?: synchronized(this) {
                CatalogueRepository(remoteDataSource).apply { instance = this }
            }
    }

    override fun getAllMovies(): List<MoviesEntity> {
        val moviesResponses = remoteDataSource.getAllMovies()
        val moviesList = ArrayList<MoviesEntity>()
        for (response in moviesResponses) {
            val movies = MoviesEntity(
                id = response.id,
                photo = response.photo,
                backdropPath = response.backdropPath,
                genre = response.genre,
                title = response.title,
                overview = response.overview,
                releaseDate = response.releaseDate,
                rating = response.rating,
                homepage = response.homepage,
                runtime = response.runtime
            )
            moviesList.add(movies)
        }
        return moviesList
    }

    override fun getMoviesById(moviesId: Int): MoviesEntity {
        val moviesResponses = remoteDataSource.getAllMovies()
        lateinit var movies: MoviesEntity
        for (response in moviesResponses) {
            if (response.id == moviesId) {
                movies = MoviesEntity(
                    id = response.id,
                    photo = response.photo,
                    backdropPath = response.backdropPath,
                    genre = response.genre,
                    title = response.title,
                    overview = response.overview,
                    releaseDate = response.releaseDate,
                    rating = response.rating,
                    homepage = response.homepage,
                    runtime = response.runtime
                )
            }
        }
        return movies
    }

    override fun getAllTvShows(): List<TvShowEntity> {
        val tvShowsResponses = remoteDataSource.getAllTvShows()
        val tvShowList = ArrayList<TvShowEntity>()
        for (response in tvShowsResponses) {
            val tvShows = TvShowEntity(
                id = response.id,
                photo = response.photo,
                backdropPath = response.backdropPath,
                genre = response.genre,
                name = response.name,
                overview = response.overview,
                firstAirDate = response.firstAirDate,
                rating = response.rating,
                homepage = response.homepage,
                episodes = response.episodes,
                seasons = response.seasons
            )
            tvShowList.add(tvShows)
        }
        return tvShowList
    }

    override fun getTvShowsById(tvShowId: Int): TvShowEntity {
        val tvShowsResponse = remoteDataSource.getAllTvShows()
        lateinit var tvShows: TvShowEntity
        for (response in tvShowsResponse) {
            if (response.id == tvShowId) {
                tvShows = TvShowEntity(
                    id = response.id,
                    photo = response.photo,
                    backdropPath = response.backdropPath,
                    genre = response.genre,
                    name = response.name,
                    overview = response.overview,
                    firstAirDate = response.firstAirDate,
                    rating = response.rating,
                    homepage = response.homepage,
                    episodes = response.episodes,
                    seasons = response.seasons
                )
            }
        }
        return tvShows
    }
}