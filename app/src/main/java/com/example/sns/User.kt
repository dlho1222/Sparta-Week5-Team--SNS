package com.example.sns

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val profile: Int,
    val contentsImage: Int,
    val description: String,
    val id: String,
    val comment: String,
) : Parcelable
