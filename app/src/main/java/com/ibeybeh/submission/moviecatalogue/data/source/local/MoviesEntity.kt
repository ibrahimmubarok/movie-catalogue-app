package com.ibeybeh.submission.moviecatalogue.data.source.local

import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.MoviesData

data class MoviesEntity(
    val id: Int,
    val posterPath: String?,
    val backdropPath: String?,
    val genre: String?,
    val title: String?,
    val overview: String?,
    val releaseDate: String?,
    val voteAverage: Double?,
    val homepage: String?,
    val runtime: String?
)

fun MoviesData.mapToMoviesEntity(): MoviesEntity {
    return MoviesEntity(
        id = id,
        posterPath = "https://image.tmdb.org/t/p/original$posterPath",
        backdropPath = "https://image.tmdb.org/t/p/original$backdropPath",
        genre = genre,
        title = title,
        overview = overview,
        releaseDate = releaseDate,
        voteAverage = voteAverage,
        homepage = homepage,
        runtime = runtime
    )
}