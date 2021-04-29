package com.ibeybeh.submission.moviecatalogue.data.source.local

data class MoviesEntity(
    val id: Int?,
    val photo: String?,
    val backdropPath: String?,
    val genre: String?,
    val title: String?,
    val overview: String?,
    val releaseDate: String?,
    val rating: Double?,
    val homepage: String?,
    val runtime: String?
)