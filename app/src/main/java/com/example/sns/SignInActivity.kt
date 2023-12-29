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
    private var userName = ""

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

                userName = it.data?.getStringExtra(USER_NAME) ?: ""
                val userEmail = it.data?.getStringExtra(USER_EMAIL) ?: ""
                val userPw = it.data?.getStringExtra(USER_PASSWORD) ?: ""

                val intent = Intent(this, MainActivity::class.java).apply {

                    putExtra(USER_NAME, userName)
                    putExtra(EMAIL,userEmail)

                }
                setResult(RESULT_OK, intent)
                Log.d("SignInActivity1","userName : $userName")

                user_Email.setText(userEmail)
                user_Pw.setText(userPw)
            }
        }

        // 로그인 버튼 클릭 시 MainActivity로 전환
        btn_login.setOnClickListener {
            //val userEmailInfo = UserInfoList.findUserInfoWithEmail(user_Email.text.toString())


            // 입력받은 이메일, 비밀번호 데이터 값
            val userEmail_data = user_Email.text.toString()
            val userPw_data = user_Pw.text.toString()


            if (user_Email.text.trim().isEmpty() || user_Pw.text.trim().isEmpty()) {
                Toast.makeText(this, getString(R.string.toast_msg_idpwNoInput), Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent()
                intent.putExtra(USER_NAME, userName)

                setResult(RESULT_OK, intent)
                //Log.d("SignInActivity2","userName : $userName")
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