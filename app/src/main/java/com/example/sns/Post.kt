package com.example.sns

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Post(
    val profile: Int,
    val contentsImage: Int,
    val id: String,
    val description: String,
    val comment: String,
    val EngName: String,
    val KR_Name: String,
    val MBTI: String,
    val Status: String,
    var isLike: Boolean = false
) : Parcelable
