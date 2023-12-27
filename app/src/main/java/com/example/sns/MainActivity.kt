package com.example.sns

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
            val snackbar = Snackbar.make(findViewById(android.R.id.content), "공지 : 아주 특별 이벤트가 있습니다!! 자리로 가장 먼저 오시는 분께 소고기 오마카세!!", Snackbar.LENGTH_INDEFINITE)
            snackbar.setAction("닫기") {
                snackbar.dismiss()
            }
            snackbar.show()
        }, 5000)

        fun popUpSnackbar(view: View) {
            val snackbar = Snackbar.make(findViewById(android.R.id.content), "공지 : 아주 특별 이벤트가 있습니다!! 자리로 가장 먼저 오시는 분께 소고기 오마카세!!", Snackbar.LENGTH_INDEFINITE)
            snackbar.setAction("닫기") {
                snackbar.dismiss()
            }
            snackbar.show()
        }
        //클릭 리스너로 사용하는 방법을 생각해 볼 것
//sefsefsef

        /*

                fun goToDetail(view: View) {
                    //Toast.makeText(view.context, "디테일 페이지로 이동합니다", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, DetailActivity::class.java)
                    startActivity(intent)
                }
                fun goToSignIn(view: View) {
                    //Toast.makeText(view.context, "로그인 페이지로 이동합니다", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, SignInActivity::class.java)
                    startActivity(intent)
                }
                fun goToMyPage(view: View) {
                    //Toast.makeText(view.context, "내 정보 페이지로 이동합니다", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, MypageActivity::class.java)
                    startActivity(intent)
                }
        */


    }
}

