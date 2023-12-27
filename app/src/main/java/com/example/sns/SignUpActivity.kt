package com.example.sns

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {

//    lateinit var userName:EditText
//    lateinit var BtnDone:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // 이름, 이메일, 비밀번호 각 EditText와 연결 / 버튼 연결
        val user_name = findViewById<EditText>(R.id.et_signUpName)
        val user_email = findViewById<EditText>(R.id.et_signUpEmail)
        val user_pw = findViewById<EditText>(R.id.et_signUpPassword)

        //val btn_repeatCheck = findViewById<Button>(R.id.btn_repeatCheck)
        val btn_cancel = findViewById<Button>(R.id.btn_cancel)
        val btn_done = findViewById<Button>(R.id.btn_done)

        btn_cancel.setOnClickListener {
            Toast.makeText(this, "취소하셨습니다", Toast.LENGTH_SHORT).show()
            finish()
        }

        btn_done.setOnClickListener {
            // 이름, 이메일, 비밀번호 데이터 값 (로그인 페이지에 넘겨줄 때 사용)
            val userName_data = user_name.text.toString()
            val userEmail_data = user_email.text.toString()
            val userPw_data = user_pw.text.toString()

            // 이름, 아이디, 비밀번호 값이 없을 경우엔 토스트 외 반응x
            if (userName_data.trim().isEmpty() || userEmail_data.trim()
                    .isEmpty() || userPw_data.trim().isEmpty()
            ) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
            } else {
                // 이름 데이터 값 MainActivity에 넘기기
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("name", userName_data)
//                Log.d("SignUpActivity", "name : $userName_data")

                Toast.makeText(this, "회원가입 성공!", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }
    }
}