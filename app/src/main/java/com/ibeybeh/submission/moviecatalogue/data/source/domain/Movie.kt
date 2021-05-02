package com.ibeybeh.submission.moviecatalogue.data.source.domain

import android.os.Parcelable
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.model.DetailMovieData
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.model.MoviesData
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val adult: Boolean? = false,
    val backdropPath: String? = null,
    val genreIds: List<Int>? = emptyList(),
    val id: Int? = 0,
    val overview: String? = null,
    val posterPath: String? = null,
    val releaseDate: String? = null,
    val title: String? = null,
    val voteAverage: Double? = 0.0
) : Parcelable

fun MoviesData.mapToListMovie(): Movie {
    return Movie(
        adult = adult,
        backdropPath = "https://image.tmdb.org/t/p/original/$backdropPath",
        genreIds = genreIds,
        id = id,
        overview = overview,
        posterPath = "https://image.tmdb.org/t/p/original/$posterPath",
        releaseDate = releaseDate,
        title = title,
        voteAverage = voteAverage
    )
}

@Parcelize
data class DetailMovie(
    val backdropPath: String? = null,
    val genres: String? = null,
    val homepage: String? = null,
    val id: Int? = 0,
    val originalTitle: String? = null,
    val overview: String? = null,
    val posterPath: String? = null,
    val releaseDate: String? = null,
    val runtime: Int? = 0,
    val title: String? = null,
    val voteAverage: Double? = 0.0,
) : Parcelable

fun DetailMovieData.mapToByIdMovie(): DetailMovie {
    return DetailMovie(
        backdropPath = "https://image.tmdb.org/t/p/original$backdropPath",
        genres = genres?.joinToString {
            "${it.name}"
        },
        homepage = homepage,
        id = id,
        originalTitle = originalTitle,
        overview = overview,
        posterPath = "https://image.tmdb.org/t/p/original$posterPath",
        releaseDate = releaseDate,
        runtime = runtime,
        title = title,
        voteAverage = voteAverage
    )
}