package com.mrenann.challengem2u.model.movieDetailed

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
 class MovieResult (
        @SerializedName("genre_ids")
        val genreIds: MutableList<Int>,
        var id: Int,
        @SerializedName("poster_path")
        var posterPath: String?,
        @SerializedName("release_date")
        val releaseDate: String?,
        var title: String?,
        var name: String?,
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