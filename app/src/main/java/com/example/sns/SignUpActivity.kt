package com.example.sns

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.get_in_trans, R.anim.get_out_trans)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // 이름, 이메일, 비밀번호 각 EditText와 연결 / 버튼 연결
        val user_name = findViewById<EditText>(R.id.et_signUpName)
        val user_email = findViewById<EditText>(R.id.et_signUpEmail)
        val user_pw = findViewById<EditText>(R.id.et_signUpPassword)

        // 이메일 중복일 때 0, 아닐 때 1을 주고 answer != 0일 때만 액티비티를 넘어갈 수 있도록 함
        var answer = 0

        validation(user_email)

        val btn_repeatCheck = findViewById<Button>(R.id.btn_repeatCheck)
        val btn_cancel = findViewById<Button>(R.id.btn_cancel)
        val btn_done = findViewById<Button>(R.id.btn_done)

        btn_repeatCheck.setOnClickListener {
            val userInfo = UserInfoList.findUserInfoWithEmail(user_email.text.toString())

            if (userInfo != null) {
                Toast.makeText(this,getString(R.string.toast_msg_impossibleEmail),Toast.LENGTH_SHORT).show()
                answer = 0
            } else {
                Toast.makeText(this,getString(R.string.toast_msg_possibleEmail),Toast.LENGTH_SHORT).show()
                answer = 1
            }
        }


        btn_cancel.setOnClickListener {
            Toast.makeText(this, getString(R.string.toast_msg_cancel), Toast.LENGTH_SHORT).show()
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
                Toast.makeText(this, getString(R.string.toast_msg_noInput), Toast.LENGTH_SHORT).show()
            } else if (answer == 0){
                Toast.makeText(this,getString(R.string.toast_msg_checkEmail),Toast.LENGTH_SHORT).show()
            } else if (!check(user_email)) {
                Toast.makeText(this, getString(R.string.toast_msg_notEmailForm), Toast.LENGTH_SHORT).show()
            } else {
                // 이름 데이터 값 SignInActivity에 넘기기
                val intent = Intent(this, SignInActivity::class.java).apply {
                    putExtra(USER_NAME, userName_data)
                    putExtra(USER_EMAIL, userEmail_data)
                    putExtra(USER_PASSWORD, userPw_data)
                }
                setResult(RESULT_OK, intent)

                Log.d("SignUpActivity","userName : $userName_data")

                Toast.makeText(this, getString(R.string.toast_msg_signUp), Toast.LENGTH_SHORT).show()

                UserInfoList.add(UserInfo(userEmail_data,userName_data,userPw_data, "", "", "",R.drawable.testimg))

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
                        R.id.et_signUpEmail -> editText.error = getString(R.string.toast_msg_notEmailForm)
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