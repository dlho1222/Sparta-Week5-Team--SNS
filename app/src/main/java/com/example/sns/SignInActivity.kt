package com.example.sns

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {

    lateinit var getIdentity: ActivityResultLauncher<Intent>
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.get_in_trans, R.anim.get_out_trans)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        // 이메일, 비밀번호 각 EditText와 연결
        val user_Email = findViewById<EditText>(R.id.et_signInEmail)
        val user_Pw = findViewById<EditText>(R.id.et_signInPassword)
        // 버튼 연결
        val btn_login = findViewById<Button>(R.id.btn_login)
        val btn_signup = findViewById<Button>(R.id.btn_signup)

        getIdentity = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == RESULT_OK) {
                val userName = it.data?.getStringExtra("userName_DataFromSignUpActivity") ?: ""
                val userEmail = it.data?.getStringExtra("userEmail_DataFromSignUpActivity") ?: ""
                val userPw = it.data?.getStringExtra("userPw_DataFromSignUpActivity") ?: ""

                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("userName_DataFromSignUpActivity", userName)
                }
                setResult(RESULT_OK, intent)

                user_Email.setText(userEmail)
                user_Pw.setText(userPw)
            }
        }

        // 로그인 버튼 클릭 시 MainActivity로 전환
        btn_login.setOnClickListener {

            // 입력받은 이메일, 비밀번호 데이터 값
            val userEmail_data = user_Email.text.toString()
            val userPw_data = user_Pw.text.toString()

            if (userEmail_data.trim().isEmpty() || userPw_data.trim().isEmpty()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                finish()
            }
        }

        // 회원가입 버튼 클릭 시 SignUpActivity로 전환
        btn_signup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            getIdentity.launch(intent)
        }
    }
}