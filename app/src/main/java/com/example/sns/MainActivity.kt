package com.example.sns

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvrep1_1: TextView = findViewById(R.id.tv_profile1_desc)
        val tvrep1_2: TextView = findViewById(R.id.tv_profile1_comm)
        val tvrep1_3: TextView = findViewById(R.id.tv_profile1_id)
        val tvrep1_4: ImageView = findViewById(R.id.iv_profile1_con)
        val tvrep1_5: ImageView = findViewById(R.id.iv_profile1)

        if (contentList.isNotEmpty()) {
            val firstContent = contentList[0]
            tvrep1_1.text = "[${firstContent.id}]  ${firstContent.description}"
            tvrep1_2.text = "${firstContent.comment}"
            tvrep1_3.text = "${firstContent.id}"
            tvrep1_4.setImageResource(firstContent.img)
            tvrep1_5.setImageResource(firstContent.profile)
        }

        val btn_signIn = findViewById<TextView>(R.id.tv_signIn)
        val tv_name = findViewById<TextView>(R.id.tv_signedIn)

        btn_signIn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.get_in_trans, R.anim.get_out_trans)
            //(호출하는 엑티비티,사라지는 엑티비티)
            //뒤로가기 버튼 클릭시 애니메이션은 호출한 액티비티에 구현해야 할 듯
        }

        val userName_data = intent.getStringExtra("name_DataFromSignUpActivity")
//        Log.d("MainActivity","name : $userName_data")
        tv_name.setText(userName_data.toString())
//        Log.d("MainActivity","name : ${intent.hasExtra("name")}")

        if (intent.hasExtra("name_DataFromSignUpActivity")) {
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
                "공지 : 아주 특별 이벤트가 있습니다!! 자리로 가장 먼저 오시는 분께 소고기 오마카세!!",
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

    //클릭 리스너로 사용하는 방법을 생각해 볼 것


    fun goToMyPage(view: View) {
        //Toast.makeText(view.context, "마이 페이지로 이동합니다", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, MypageActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.get_in_trans, R.anim.get_out_trans)
    }


}

