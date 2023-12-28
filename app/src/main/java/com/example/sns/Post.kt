package com.example.sns

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Post(
    val profile: Int,
    val contentsImage: Int,
    val description: String,
    val krName: String,
    val engName: String,
    val comment: String,
    var isLike: Boolean = false
) : Parcelable