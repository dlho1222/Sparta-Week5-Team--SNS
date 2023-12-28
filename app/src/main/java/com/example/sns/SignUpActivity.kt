package com.example.sns

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.w3c.dom.Text
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // 이름, 이메일, 비밀번호 각 EditText와 연결 / 버튼 연결
        val user_name = findViewById<EditText>(R.id.et_signUpName)
        val user_email = findViewById<EditText>(R.id.et_signUpEmail)
        val user_pw = findViewById<EditText>(R.id.et_signUpPassword)

        validation(user_name)
        validation(user_email)
        validation(user_pw)

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
            } else if (!check(user_email)) {
                Toast.makeText(this, "이메일 형식을 지켜주세요", Toast.LENGTH_SHORT).show()
            } else {
                // 이름 데이터 값 SignInActivity에 넘기기
                val intent = Intent(this, SignInActivity::class.java).apply {
                    putExtra("name_DataFromSignUpActivity", userName_data)
                    putExtra("userEmail_DataFromSignUpActivity", userEmail_data)
                    putExtra("userPw_DataFromSignUpActivity", userPw_data)
//                Log.d("SignUpActivity", "name : $userName_data")
                }
                setResult(RESULT_OK, intent)
                Toast.makeText(this, "회원가입 성공!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    private fun validation(editText: EditText) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // text가 변경된 후 호출
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // text가 변경되기 전 호출
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // text가 바뀔 때마다 호출
                if (editText.text.length == 0 || editText.text.isNullOrEmpty() || !editText.text.contains(
                        "@"
                    )
                ) {
                    when (editText.id) {
                        R.id.et_signUpEmail -> editText.error = "이메일형식을 지켜주세요"
                        else -> ""
                    }
                }
            }
        })
    }

    private fun check(editText: EditText): Boolean {
        val email = "[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$"
        val pattern = Pattern.compile(email)
        return pattern.matcher(editText.text).matches()
    }
}