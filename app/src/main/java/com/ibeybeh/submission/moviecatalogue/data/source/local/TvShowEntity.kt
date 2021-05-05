package com.ibeybeh.submission.moviecatalogue.data.source.local

import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.TvShowData

data class TvShowEntity(
    val id: Int,
    val posterPath: String?,
    val backdropPath: String?,
    val genre: String?,
    val name: String?,
    val overview: String?,
    val firstAirDate: String?,
    val voteAverage: Double?,
    val homepage: String?,
    val numberOfEpisodes: Int?,
    val numberOfSeasons: Int?
)

fun TvShowData.mapToTvShowEntity(): TvShowEntity {
    return TvShowEntity(
        id = id,
        posterPath = "https://image.tmdb.org/t/p/original$posterPath",
        backdropPath = "https://image.tmdb.org/t/p/original$backdropPath",
        genre = genre,
        name = name,
        overview = overview,
        firstAirDate = firstAirDate,
        voteAverage = voteAverage,
        homepage = homepage,
        numberOfEpisodes = numberOfEpisodes,
        numberOfSeasons = numberOfSeasons
    )
}