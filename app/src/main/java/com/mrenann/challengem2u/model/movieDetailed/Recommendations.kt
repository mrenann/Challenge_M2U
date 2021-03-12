package com.mrenann.challengem2u.model.movieDetailed

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Recommendations(
        val page: Int,
        var results: List<MovieResult>?,
        val total_pages: Int,
        val total_results: Int
): Parcelable