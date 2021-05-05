package com.ibeybeh.submission.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShowData(
    val id: Int = 0,
    val posterPath: String? = null,
    val backdropPath: String? = null,
    val genre: String? = null,
    val name: String? = null,
    val overview: String? = null,
    val firstAirDate: String? = null,
    val voteAverage: Double? = 0.0,
    val homepage: String? = null,
    val numberOfEpisodes: Int? = 0,
    val numberOfSeasons: Int? = 0
): Parcelable