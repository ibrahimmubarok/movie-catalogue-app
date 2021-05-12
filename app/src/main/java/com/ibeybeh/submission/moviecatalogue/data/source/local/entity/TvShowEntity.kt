package com.ibeybeh.submission.moviecatalogue.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ibeybeh.submission.moviecatalogue.data.source.remote.response.TvShowData
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tbl_favorite_tv_show")
@Parcelize
data class TvShowEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "poster_path")
    val posterPath: String?,

    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?,

    @ColumnInfo(name = "genre")
    val genre: String?,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "overview")
    val overview: String?,

    @ColumnInfo(name = "first_air_date")
    val firstAirDate: String?,

    @ColumnInfo(name = "vote_average")
    val voteAverage: Double?,

    @ColumnInfo(name = "homepage")
    val homepage: String?,

    @ColumnInfo(name = "number_of_episodes")
    val numberOfEpisodes: Int?,

    @ColumnInfo(name = "number_of_seasons")
    val numberOfSeasons: Int?,

    @NonNull
    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean = false
): Parcelable

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