package com.example.sns


import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment

class MypageActivity : AppCompatActivity() {

    private var userInfo : UserInfo? = null

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.get_in_trans, R.anim.get_out_trans)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)
        val ivProfilePic = findViewById<ImageView>(R.id.iv_profilePic)
        val ivEditname = findViewById<ImageView>(R.id.iv_editname)
        val ivNameok = findViewById<ImageView>(R.id.iv_nameok)
        val ivEditmbtihobby = findViewById<ImageView>(R.id.iv_editMbtiHobby)
        val ivMbtihobbyok = findViewById<ImageView>(R.id.iv_mbtiHobbyOk)
        val delPost1 = findViewById<ImageView>(R.id.iv_deleteIcon1)
        val delPost2 = findViewById<ImageView>(R.id.iv_deleteIcon2)
        val delPost3 = findViewById<ImageView>(R.id.iv_deleteIcon3)

        userInfo = intent.getParcelableExtra(USER_INFO)

        userInfo?.profileImg?.let {
            ivProfilePic.setImageResource(it) }

        userInfo?.name?.let{
            findViewById<TextView>(R.id.tv_mypageName).text = it  }

        userInfo?.comment?.let{
            findViewById<TextView>(R.id.tv_mypageComment).text = it }

        userInfo?.mbti?.let{
            findViewById<TextView>(R.id.tv_mbti).text = it }

        userInfo?.hobby?.let{
            findViewById<TextView>(R.id.tv_hobby).text = it }

        ivProfilePic.setOnClickListener {
            openGallery()
        }
        ivEditname.setOnClickListener {
            ivEditname.isGone = true
            ivNameok.isVisible = true
            editNameCommentClick(ivEditname.id)
        }
        ivNameok.setOnClickListener {
            ivNameok.isGone = true
            ivEditname.isVisible = true
            editNameCommentClick(ivNameok.id)
        }
        ivEditmbtihobby.setOnClickListener {
            ivEditmbtihobby.isGone = true
            ivMbtihobbyok.isVisible = true
            editMbtiHobbyClick(ivEditmbtihobby.id)
        }
        ivMbtihobbyok.setOnClickListener {
            ivMbtihobbyok.isGone = true
            ivEditmbtihobby.isVisible = true
            editMbtiHobbyClick(ivMbtihobbyok.id)
        }
        delPost1.setOnClickListener {
            val post = findViewById<ConstraintLayout>(R.id.constraintLayout_post1)
            deletePost(post)
        }
        delPost2.setOnClickListener {
            val post = findViewById<ConstraintLayout>(R.id.constraintLayout_post2)
            deletePost(post)
        }
        delPost3.setOnClickListener {
            val post = findViewById<ConstraintLayout>(R.id.constraintLayout_post3)
            deletePost(post)
        }


    }

    private val pickImageLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val imageUri: Uri? = result.data?.data
                findViewById<ImageView>(R.id.iv_profilePic)?.setImageURI(imageUri)
            }
        }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK) //암시적인텐트
        intent.type = "image/*"
        pickImageLauncher.launch(intent)
    }

    private fun editNameCommentClick(id: Int) {
        val etName = findViewById<EditText>(R.id.et_mypageName)
        val etComment = findViewById<EditText>(R.id.et_mypageComment)
        val tvName = findViewById<TextView>(R.id.tv_mypageName)
        val tvComment = findViewById<TextView>(R.id.tv_mypageComment)

        when (id) {
            R.id.iv_editname -> {
                tvName.isGone = true
                tvComment.isGone = true
                etName.isVisible = true
                etComment.isVisible = true
                etName.setText(tvName.text)
                etComment.setText(tvComment.text)
            }

            R.id.iv_nameok -> {
                etName.isGone = true
                etComment.isGone = true
                tvName.isVisible = true
                tvComment.isVisible = true
                tvName.text = etName.text
                tvComment.text = etComment.text
            }
        }
    }

    private fun editMbtiHobbyClick(id: Int) {
        val etMbti = findViewById<EditText>(R.id.et_mbti)
        val etHobby = findViewById<EditText>(R.id.et_hobby)
        val tvMbti = findViewById<TextView>(R.id.tv_mbti)
        val tvHobby = findViewById<TextView>(R.id.tv_hobby)

        when (id) {
            R.id.iv_editMbtiHobby -> {
                tvMbti.isGone = true
                tvHobby.isGone = true
                etMbti.isVisible = true
                etHobby.isVisible = true
                etMbti.setText(tvMbti.text)
                etHobby.setText(tvHobby.text)
            }

            R.id.iv_mbtiHobbyOk -> {
                etMbti.isGone = true
                etHobby.isGone = true
                tvMbti.isVisible = true
                tvHobby.isVisible = true
                tvMbti.text = etMbti.text
                tvHobby.text = etHobby.text
            }
        }
    }

    fun deletePost(post: View) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("정말 삭제하시겠습니까?")
            .setPositiveButton("확인", { dialog, id ->
                post.isGone = true
            })
            .setNegativeButton("취소",
                { dialog, id ->

                })
        builder.show()
    }
}
