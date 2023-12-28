package com.example.sns

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class UserInfo(
    val email: String,
    val name: String,
    val password: String,
    var comment: String,
    var hobby: String,
    var mbti: String,
    val profileImg: Int
) : Parcelable