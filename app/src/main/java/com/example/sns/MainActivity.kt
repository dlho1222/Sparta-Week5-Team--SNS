package com.example.sns

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var getName: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val profile1 = findViewById<ImageView>(R.id.iv_profile1_con).setOnClickListener {
            goToDetail(it, UserList.get(0))
        }

        val profile2 = findViewById<ImageView>(R.id.iv_profile2_con).apply {
            setOnClickListener {
                goToDetail(it, UserList.get(1))
            }
        }
        val profile3 = findViewById<ImageView>(R.id.iv_profile3_con).apply {
            setOnClickListener {
                goToDetail(it, UserList.get(2))
            }
        }

        val profile4 = findViewById<ImageView>(R.id.iv_profile4_con).apply {
            setOnClickListener {
                goToDetail(it, UserList.get(3))
            }
        }


        val btn_signIn = findViewById<TextView>(R.id.tv_signIn)
        val tv_name = findViewById<TextView>(R.id.tv_signedIn)

        getName = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == RESULT_OK) {
                val userName = it.data?.getStringExtra("userName_DataFromSignUpActivity") ?: ""

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

        if (intent.hasExtra("userName_DataFromSignUpActivity")) {
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

    private fun goToDetail(view: View, UserContents: User) {
        //Toast.makeText(view.context, "디테일 페이지로 이동합니다", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra("user", UserContents)
        }
        startActivity(intent)
    }

    fun goToMyPage(view: View) {
        //Toast.makeText(view.context, "마이 페이지로 이동합니다", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, MypageActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.get_in_trans, R.anim.get_out_trans)
    }
}










