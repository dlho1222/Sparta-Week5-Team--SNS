package com.example.sns

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var getName: ActivityResultLauncher<Intent>
    private var id = ""
    private var email = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rep1_1 = findViewById<ImageView>(R.id.iv_profile1)
        rep1_1.setImageResource(PostList.get(0).profile)
        val rep1_2: TextView = findViewById(R.id.tv_profile1_id)
        rep1_2.text = "${PostList.get(0).id}"
        val rep1_3: ImageView = findViewById(R.id.iv_profile1_con)
        rep1_3.setImageResource(PostList.get(0).contentsImage)
        val rep1_4: TextView = findViewById(R.id.tv_profile1_desc)
        rep1_4.text = "[${PostList.get(0).id}]  ${PostList.get(0).description}"
        val rep1_5: TextView = findViewById(R.id.tv_profile1_comm)
        rep1_5.text = "${PostList.get(0).comment}"

        val rep2_1: ImageView = findViewById(R.id.iv_profile2)
        rep2_1.setImageResource(PostList.get(1).profile)
        val rep2_2: TextView = findViewById(R.id.tv_profile2_id)
        rep2_2.text = "${PostList.get(1).id}"
        val rep2_3: ImageView = findViewById(R.id.iv_profile2_con)
        rep2_3.setImageResource(PostList.get(1).contentsImage)
        val rep2_4: TextView = findViewById(R.id.tv_profile2_desc)
        rep2_4.text = "[${PostList.get(1).id}]  ${PostList.get(1).description}"
        val rep2_5: TextView = findViewById(R.id.tv_profile2_comm)
        rep2_5.text = "${PostList.get(1).comment}"

        val rep3_1: ImageView = findViewById(R.id.iv_profile3)
        rep3_1.setImageResource(PostList.get(2).profile)
        val rep3_2: TextView = findViewById(R.id.tv_profile3_id)
        rep3_2.text = "${PostList.get(2).id}"
        val rep3_3: ImageView = findViewById(R.id.iv_profile3_con)
        rep3_3.setImageResource(PostList.get(2).contentsImage)
        val rep3_4: TextView = findViewById(R.id.tv_profile3_desc)
        rep3_4.text = "[${PostList.get(2).id}]  ${PostList.get(2).description}"
        val rep3_5: TextView = findViewById(R.id.tv_profile3_comm)
        rep3_5.text = "${PostList.get(2).comment}"

        val rep4_1: ImageView = findViewById(R.id.iv_profile4)
        rep4_1.setImageResource(PostList.get(3).profile)
        val rep4_2: TextView = findViewById(R.id.tv_profile4_id)
        rep4_2.text = "${PostList.get(3).id}"
        val rep4_3: ImageView = findViewById(R.id.iv_profile4_con)
        rep4_3.setImageResource(PostList.get(3).contentsImage)
        val rep4_4: TextView = findViewById(R.id.tv_profile4_desc)
        rep4_4.text = "[${PostList.get(3).id}]  ${PostList.get(3).description}"
        val rep4_5: TextView = findViewById(R.id.tv_profile4_comm)
        rep4_5.text = "${PostList.get(3).comment}"


        val profile1 = findViewById<ImageView>(R.id.iv_profile1_con).setOnClickListener {
            goToDetail(it, PostList.get(0))
        }

        val profile2 = findViewById<ImageView>(R.id.iv_profile2_con).apply {
            setOnClickListener {
                goToDetail(it, PostList.get(1))
            }
        }
        val profile3 = findViewById<ImageView>(R.id.iv_profile3_con).apply {
            setOnClickListener {
                goToDetail(it, PostList.get(2))
            }
        }

        val profile4 = findViewById<ImageView>(R.id.iv_profile4_con).apply {
            setOnClickListener {
                goToDetail(it, PostList.get(3))
            }
        }

        val goTomyPage = findViewById<TextView>(R.id.tv_signedIn).apply {
            setOnClickListener {
                goToMyPage(it)
            }
        }

        /*
        val reels1 = findViewById<ImageView>(R.id.iv_reels1).setOnClickListener {
            goToReels(it, PostList.get(0))
        }
        reels1.setImageResource(PostList.get(0).profile)
        */

        val reels1 = findViewById<ImageView>(R.id.iv_reels1)
        reels1.setOnClickListener {
            goToReels(it, ReelsList.get(0))
        }
        reels1.setImageResource(ReelsList.get(0).profile)
        val reels1_1 = findViewById<TextView>(R.id.tv_reels1)
        reels1_1.text = "${ReelsList.get(0).id}"

        val reels2 = findViewById<ImageView>(R.id.iv_reels2)
        reels2.setOnClickListener {
            goToReels(it, ReelsList.get(1))
        }
        reels2.setImageResource(ReelsList.get(1).profile)
        val reels2_1 = findViewById<TextView>(R.id.tv_reels2)
        reels2_1.text = "${ReelsList.get(1).id}"

        val reels3 = findViewById<ImageView>(R.id.iv_reels3)
        reels3.setOnClickListener {
            goToReels(it, ReelsList.get(2))
        }
        reels3.setImageResource(ReelsList.get(2).profile)
        val reels3_1 = findViewById<TextView>(R.id.tv_reels3)
        reels3_1.text = "${ReelsList.get(2).id}"

        val reels4 = findViewById<ImageView>(R.id.iv_reels4)
        reels4.setOnClickListener {
            goToReels(it, ReelsList.get(3))
        }
        reels4.setImageResource(ReelsList.get(3).profile)
        val reels4_1 = findViewById<TextView>(R.id.tv_reels4)
        reels4_1.text = "${ReelsList.get(3).id}"

        val reels5 = findViewById<ImageView>(R.id.iv_reels5)
        reels5.setOnClickListener {
            goToReels(it, ReelsList.get(4))
        }
        reels5.setImageResource(ReelsList.get(4).profile)
        val reels5_1 = findViewById<TextView>(R.id.tv_reels5)
        reels5_1.text = "${ReelsList.get(4).id}"

        val reels6 = findViewById<ImageView>(R.id.iv_reels6)
        reels6.setOnClickListener {
            goToReels(it, ReelsList.get(5))
        }
        reels6.setImageResource(ReelsList.get(5).profile)
        val reels6_1 = findViewById<TextView>(R.id.tv_reels6)
        reels6_1.text = "${ReelsList.get(5).id}"

        val reels7 = findViewById<ImageView>(R.id.iv_reels7)
        reels7.setOnClickListener {
            goToReels(it, ReelsList.get(6))
        }
        reels7.setImageResource(ReelsList.get(6).profile)
        val reels7_1 = findViewById<TextView>(R.id.tv_reels7)
        reels7_1.text = "${ReelsList.get(6).id}"

        val reels8 = findViewById<ImageView>(R.id.iv_reels8)
        reels8.setOnClickListener {
            goToReels(it, ReelsList.get(7))
        }
        reels8.setImageResource(ReelsList.get(7).profile)
        val reels8_1 = findViewById<TextView>(R.id.tv_reels8)
        reels8_1.text = "${ReelsList.get(7).id}"


        val btn_signIn = findViewById<TextView>(R.id.tv_signIn)
        val tv_name = findViewById<TextView>(R.id.tv_signedIn)

        // SignInActivity에서 이름, 이메일 받아오도록
        getName = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == RESULT_OK) {
                val userName = it.data?.getStringExtra(USER_NAME) ?: ""
                id = userName
                email = it.data?.getStringExtra(EMAIL) ?: ""

                tv_name.text = userName
                btn_signIn.visibility = View.INVISIBLE
                tv_name.visibility = View.VISIBLE
            }
        }


        btn_signIn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            getName.launch(intent)
            overridePendingTransition(R.anim.get_in_trans, R.anim.get_out_trans)
            //(호출하는 엑티비티,사라지는 엑티비티)
            //뒤로가기 버튼 클릭시 애니메이션은 호출한 액티비티에 구현해야 할 듯
        }

        if (intent.hasExtra(USER_NAME)) {
            btn_signIn.visibility = View.INVISIBLE
            tv_name.visibility = View.VISIBLE
        } else {
            btn_signIn.visibility = View.VISIBLE
            tv_name.visibility = View.INVISIBLE
        }


        /*
            Handler(Looper.getMainLooper()).postDelayed({
                Snackbar.make(findViewById(android.R.id.content), "공지 : 아주 특별 이벤트가 있습니다!! 자리로 가장 먼저 오시는 분께 소고기 오마카세!!", Snackbar.LENGTH_LONG).show()
            }, 5000)
            //findViewById로 루트 뷰를 가져온다고 함
    */

        /*
            val snackbar = Snackbar.make(findViewById(android.R.id.content), "공지 : 아주 특별 이벤트가 있습니다!! 자리로 가장 먼저 오시는 분께 소고기 오마카세!!", Snackbar.LENGTH_INDEFINITE)
            snackbar.setAction("닫기") {
                snackbar.dismiss()
            }
            snackbar.show()
    */

        Handler(Looper.getMainLooper()).postDelayed({
            val snackbar = Snackbar.make(
                findViewById(android.R.id.content),
                "공지 : 4조 스낵바 뿜!",
                Snackbar.LENGTH_INDEFINITE
            )
            snackbar.setAction("닫기") {
                snackbar.dismiss()
            }
            snackbar.show()
        }, 5000)

        fun popUpSnackbar(view: View) {
            val snackbar = Snackbar.make(
                findViewById(android.R.id.content),
                "공지 : 아주 특별 이벤트가 있습니다!! 자리로 가장 먼저 오시는 분께 소고기 오마카세!!",
                Snackbar.LENGTH_INDEFINITE
            )
            snackbar.setAction("닫기") {
                snackbar.dismiss()
            }
            snackbar.show()
        }
    }

    private fun goToDetail(view: View, postContents: Post) {
        //Toast.makeText(view.context, "디테일 페이지로 이동합니다", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra(POST_INFO, postContents)
            putExtra(ID, id)
        }
        startActivity(intent)
        overridePendingTransition(R.anim.get_slide_in_trans, R.anim.get_none_trans)
    }

    fun goToMyPage(view: View) {
        //Toast.makeText(view.context, "마이 페이지로 이동합니다", Toast.LENGTH_SHORT).show()
        var userInfo = UserInfoList.findUserInfoWithEmail(email)


        val intent = Intent(this, MypageActivity::class.java).apply {
            putExtra(ID, id)
            startActivity(this)
            overridePendingTransition(R.anim.get_in_trans, R.anim.get_out_trans)
        }
    }

    private fun goToReels(view: View, reelsContents: Reels) {
        //Toast.makeText(view.context, "디테일 페이지로 이동합니다", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, ReelsActivity::class.java).apply {
            putExtra(REELS_INFO, reelsContents)
            putExtra(ID, id)
        }
        startActivity(intent)
        overridePendingTransition(R.anim.get_in_trans, R.anim.get_none_trans)

    }

}










