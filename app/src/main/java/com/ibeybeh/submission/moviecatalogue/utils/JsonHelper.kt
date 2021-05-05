package com.ibeybeh.submission.moviecatalogue.utils

import android.content.Context
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.MoviesData
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.TvShowData
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.util.ArrayList

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MoviesData> {
        val list = ArrayList<MoviesData>()
        try {
            val responseObject = JSONObject(parsingFileToString("movies.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val movies = listArray.getJSONObject(i)

                val id = movies.getInt("id")
                val posterPath = movies.getString("poster_path")
                val backdropPath = movies.getString("backdrop_path")

                val genreIds = movies.getJSONArray("genre")
                val genreList: MutableList<String> = mutableListOf()
                for (j in 0 until genreIds.length()) {
                    genreList.add(genreIds[j].toString())
                }

                val genre = genreList.joinToString(separator = " / ") { genre ->
                    genre
                }

                val title = movies.getString("title")
                val overview = movies.getString("overview")
                val releaseDate = movies.getString("release_date")
                val voteAverage = movies.getDouble("vote_average")
                val homepage = movies.getString("homepage")
                val runtime = movies.getString("runtime")

                val moviesResponse = MoviesData(
                    id = id,
                    posterPath = posterPath,
                    backdropPath = backdropPath,
                    genre = genre,
                    title = title,
                    overview = overview,
                    releaseDate = releaseDate,
                    voteAverage = voteAverage,
                    homepage = homepage,
                    runtime = runtime
                )
                list.add(moviesResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadByIdMovies(movieId: Int): MoviesData {
        var moviesData = MoviesData()
        val listArray = loadMovies()
        for (movies in listArray) {
            if (movieId == movies.id) {
                moviesData = MoviesData(
                    id = movies.id,
                    posterPath = movies.posterPath,
                    backdropPath = movies.backdropPath,
                    genre = movies.genre,
                    title = movies.title,
                    overview = movies.overview,
                    releaseDate = movies.releaseDate,
                    voteAverage = movies.voteAverage,
                    homepage = movies.homepage,
                    runtime = movies.runtime
                )
            }
        }
        return moviesData
    }

    fun loadTvShow(): List<TvShowData> {
        val list = ArrayList<TvShowData>()
        try {
            val responseObject = JSONObject(parsingFileToString("tvshow.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val tvShow = listArray.getJSONObject(i)

                val id = tvShow.getInt("id")
                val posterPath = tvShow.getString("poster_path")
                val backdropPath = tvShow.getString("backdrop_path")

                val genreIds = tvShow.getJSONArray("genre")
                val genreList: MutableList<String> = mutableListOf()
                for (j in 0 until genreIds.length()) {
                    genreList.add(genreIds[j].toString())
                }

                val genre = genreList.joinToString(separator = " / ") { genre ->
                    genre
                }

                val name = tvShow.getString("name")
                val overview = tvShow.getString("overview")
                val firstAirDate = tvShow.getString("first_air_date")
                val voteAverage = tvShow.getDouble("vote_average")
                val homepage = tvShow.getString("homepage")
                val numberOfSeasons = tvShow.getInt("number_of_seasons")
                val numberOfEpisodes = tvShow.getInt("number_of_episodes")

                val tvShowsResponse = TvShowData(
                    id = id,
                    posterPath = posterPath,
                    backdropPath = backdropPath,
                    genre = genre,
                    name = name,
                    overview = overview,
                    firstAirDate = firstAirDate,
                    voteAverage = voteAverage,
                    homepage = homepage,
                    numberOfSeasons =  numberOfSeasons,
                    numberOfEpisodes =  numberOfEpisodes
                )

                list.add(tvShowsResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadByIdTvShow(tvShowId: Int): TvShowData {
        var tvShowData = TvShowData()
        val listArray = loadTvShow()
        for (tvShow in listArray) {
            if (tvShowId == tvShow.id) {
                tvShowData = TvShowData(
                    id = tvShow.id,
                    posterPath = tvShow.posterPath,
                    backdropPath = tvShow.backdropPath,
                    genre = tvShow.genre,
                    name = tvShow.name,
                    overview = tvShow.overview,
                    firstAirDate = tvShow.firstAirDate,
                    voteAverage = tvShow.voteAverage,
                    homepage = tvShow.homepage,
                    numberOfSeasons =  tvShow.numberOfSeasons,
                    numberOfEpisodes =  tvShow.numberOfEpisodes
                )
            }
        }
        return tvShowData
    }
}