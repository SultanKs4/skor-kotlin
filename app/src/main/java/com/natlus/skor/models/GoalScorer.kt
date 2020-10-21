package com.natlus.skor.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GoalScorer(
    var name: String,
    var minute: Int
) : Parcelable