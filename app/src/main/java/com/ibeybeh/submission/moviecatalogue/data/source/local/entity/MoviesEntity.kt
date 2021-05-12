package com.ibeybeh.submission.moviecatalogue.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.MoviesData
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tbl_favorite_movie")
@Parcelize
data class MoviesEntity(

    @NonNull
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "poster_path")
    val posterPath: String?,

    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?,

    @ColumnInfo(name = "genre")
    val genre: String?,

    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "overview")
    val overview: String?,

    @ColumnInfo(name = "release_date")
    val releaseDate: String?,

    @ColumnInfo(name = "vote_average")
    val voteAverage: Double?,

    @ColumnInfo(name = "homepage")
    val homepage: String?,

    @ColumnInfo(name = "runtime")
    val runtime: String?,

    @NonNull
    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean = false

): Parcelable

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