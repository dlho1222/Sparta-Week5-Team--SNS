package com.example.sns

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

    }

}
