package com.example.sns

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MypageActivity : AppCompatActivity() {
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.get_in_trans, R.anim.get_out_trans)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)
    }
}
