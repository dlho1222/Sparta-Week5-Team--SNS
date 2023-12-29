package com.example.sns

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class UserInfo(
    var email: String,
    var name: String,
    var password: String,
    var comment: String,
    var hobby: String,
    var mbti: String,
    val profileImg: Int
) : Parcelable