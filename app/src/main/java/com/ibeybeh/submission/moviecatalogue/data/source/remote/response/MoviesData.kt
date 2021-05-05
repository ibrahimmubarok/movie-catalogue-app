package com.ibeybeh.submission.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MoviesData(
    val id: Int = 0,
    val posterPath: String? = null,
    val backdropPath: String? = null,
    val genre: String? = null,
    val title: String? = null,
    val overview: String? = null,
    val releaseDate: String? = null,
    val voteAverage: Double? = 0.0,
    val homepage: String? = null,
    val runtime: String? = null
): Parcelable
