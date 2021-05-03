package com.ibeybeh.submission.moviecatalogue.data.source.domain

import android.os.Parcelable
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.model.DetailTvShowData
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.model.TvShowsData
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShow(
    val firstAirDate: String? = null,
    val id: Int? = 0,
    val name: String? = null,
    val overview: String? = null,
    val posterPath: String? = null,
    val voteAverage: Double? = 0.0
): Parcelable

fun TvShowsData.mapToListTvShow() : TvShow {
    return TvShow(
        firstAirDate = firstAirDate,
        id = id,
        name = name,
        overview = overview,
        posterPath = "https://image.tmdb.org/t/p/original/$posterPath",
        voteAverage = voteAverage
    )
}

@Parcelize
data class DetailTvShow(
    val backdropPath: String? = null,
    val firstAirDate: String? = null,
    val genres: String? = null,
    val homepage: String? = null,
    val id: Int? = 0,
    val lastAirDate: String? = null,
    val name: String? = null,
    val numberOfEpisodes: Int? = null,
    val numberOfSeasons: Int? = null,
    val overview: String? = null,
    val posterPath: String? = null,
    val voteAverage: Double? = 0.0
): Parcelable

fun DetailTvShowData.mapToByIdTvShow() : DetailTvShow {
    return DetailTvShow(
        backdropPath = "https://image.tmdb.org/t/p/original/$backdropPath",
        firstAirDate = firstAirDate,
        genres = genres?.joinToString {
            "${it.name}"
        },
        homepage = homepage,
        id = id,
        lastAirDate = lastAirDate,
        name = name,
        numberOfEpisodes = numberOfEpisodes,
        numberOfSeasons = numberOfSeasons,
        overview = overview,
        posterPath = posterPath,
        voteAverage = voteAverage
    )
}