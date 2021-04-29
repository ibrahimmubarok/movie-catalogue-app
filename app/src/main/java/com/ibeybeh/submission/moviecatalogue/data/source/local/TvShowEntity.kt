package com.ibeybeh.submission.moviecatalogue.data.source.local

data class TvShowEntity(
    val id: Int?,
    val photo: String?,
    val backdropPath: String?,
    val genre: String?,
    val name: String?,
    val overview: String?,
    val firstAirDate: String?,
    val rating: Double?,
    val homepage: String?,
    val episodes: Int?,
    val seasons: Int?
)