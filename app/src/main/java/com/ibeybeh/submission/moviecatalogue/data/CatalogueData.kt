package com.ibeybeh.submission.moviecatalogue.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CatalogueData(
    val moviesData: MoviesData?,
    val tvShowData: TvShowData?
) : Parcelable