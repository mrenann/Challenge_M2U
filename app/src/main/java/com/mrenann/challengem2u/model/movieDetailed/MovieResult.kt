package com.mrenann.challengem2u.model.movieDetailed

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
 class MovieResult (
        val adult: Boolean?,
        @SerializedName("backdrop_path")
        var backdropPath: String?,
        @SerializedName("genre_ids")
        val genreIds: MutableList<Int>,
        val genres:String?,
        var id: Int,
        @SerializedName("first_air_date")
        var firstAirDate: String?,
        @SerializedName("origin_country")
        var originalCountry: MutableList<String>?,
        @SerializedName("original_language")
        val originalLanguage: String?,
        @SerializedName("original_title")
        val originalTitle: String?,
        val overview: String?,
        val popularity: Double?,
        @SerializedName("poster_path")
        var posterPath: String?,
        @SerializedName("release_date")
        val releaseDate: String?,
        var title: String?,
        var name: String?,
        @SerializedName("original_name")
        var originalName: String?,
        val video: Boolean?,
        @SerializedName("vote_average")
        val voteAverage: Float?,
        @SerializedName("vote_count")
        val voteCount: Int?,
        var type: Int


        ) : Parcelable {

    companion object {
        var DIFF_CALLBACK: DiffUtil.ItemCallback<MovieResult> = object : DiffUtil.ItemCallback<MovieResult>() {
            override fun areItemsTheSame(oldItem: MovieResult, newItem: MovieResult): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieResult, newItem: MovieResult): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}