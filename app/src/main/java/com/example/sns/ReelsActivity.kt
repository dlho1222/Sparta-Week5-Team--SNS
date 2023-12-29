package com.example.sns

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible

class ReelsActivity : AppCompatActivity() {
    private var reelsInfo: Reels? = null

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.get_none_trans, R.anim.get_out_trans)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reels)




        reelsInfo = intent.getParcelableExtra<Reels>(REELS_INFO)


        val ivContents = findViewById<ImageView>(R.id.iv_ContentsImage).apply {
            reelsInfo?.contentsImage?.let { setImageResource(it) }
        }
        val ivProfile = findViewById<ImageView>(R.id.iv_Profile).apply {
            reelsInfo?.profile?.let { setImageResource(it) }
        }
        val tvProfile = findViewById<TextView>(R.id.tv_profile_id).apply {
            reelsInfo?.id?.let { setText(it) }
        }
        val reelsid = findViewById<TextView>(R.id.tv_profile_id)
        reelsid.setShadowLayer(10f, 1f, 1f, Color.GRAY)
        /*
        두 가지의 방법이 있는데 findViewById로 불러와 적용하는 방법
        xml에서 Shadow에 값을 주는 방법
        https://mine-it-record.tistory.com/245
        */


    }

}
