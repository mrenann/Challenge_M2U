package com.mrenann.challengem2u.model.movieGenres

import android.os.Parcelable
import com.mrenann.challengem2u.model.movieDetailed.Genre
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GenresMovie(
    val genres: List<Genre>
): Parcelable