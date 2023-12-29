package com.example.sns

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Reels(
    val profile: Int,
    val contentsImage: Int,
    val id: String
) : Parcelable
