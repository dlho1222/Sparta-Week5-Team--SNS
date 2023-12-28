package com.example.sns

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val profile1 = findViewById<ImageView>(R.id.iv_profile1_con).setOnClickListener {
            goToDetail(it, UserList.get(0))
        }

        val profile2 = findViewById<ImageView>(R.id.iv_profile2_con).apply {
            setOnClickListener {
                goToDetail(it,UserList.get(1))
            }
        }
        val profile3 = findViewById<ImageView>(R.id.iv_profile3_con).apply {
            setOnClickListener {
                goToDetail(it,UserList.get(2))
            }
        }

        val profile4 = findViewById<ImageView>(R.id.iv_profile4_con).apply {
            setOnClickListener {
                goToDetail(it,UserList.get(3))
            }
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
        //클릭 리스너로 사용하는 방법을 생각해 볼 것
//sefsefsef


        /*fun goToSignIn(view: View) {
            //Toast.makeText(view.context, "로그인 페이지로 이동합니다", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
        fun goToMyPage(view: View) {
            //Toast.makeText(view.context, "내 정보 페이지로 이동합니다", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MypageActivity::class.java)
            startActivity(intent)
        }*/


    }

    private fun goToDetail(view: View, UserContents: User) {
        //Toast.makeText(view.context, "디테일 페이지로 이동합니다", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra("user", UserContents)
        }
        startActivity(intent)
    }
}

