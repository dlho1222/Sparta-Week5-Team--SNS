package com.example.sns

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.edit
import androidx.core.view.isVisible

class DetailActivity : AppCompatActivity() {
    private var isHeart = false //좋아요 상태
    private var saveComment = ""
    private var userInfo: User? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val toolBar = findViewById<Toolbar>(R.id.tb_ToolBar)
        val ivComment = findViewById<ImageView>(R.id.iv_AddComment)
        val etComment = findViewById<EditText>(R.id.et_Comment)
        val ivHeart = findViewById<ImageView>(R.id.iv_Heart)
        val ivEmptyHeart = findViewById<ImageView>(R.id.iv_EmptyHeart)

        userInfo = intent.getParcelableExtra<User>("user")



        toolBar.apply {
            title = "Detail"
            setSupportActionBar(this)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val ivContents = findViewById<ImageView>(R.id.iv_ContentsImage).apply {
            userInfo?.contentsImage?.let { setImageResource(it) }
        }
        val ivProfile = findViewById<ImageView>(R.id.iv_Profile).apply {
            userInfo?.profile?.let { setImageResource(it) }
        }


        ivComment.setOnClickListener {//코멘트 아이콘 눌렀을 때 commentwindow 보여줌
            //addCommentDialog()
            showCommentWindow()
        }
        val ivSend = findViewById<ImageView>(R.id.iv_Send)?.apply {
            setOnClickListener {
                if (etComment.text.isNullOrEmpty() || etComment.text.trim() == "") return@setOnClickListener
                addComment(etComment.text.toString())
                etComment.setText("") //다이렉트 아이콘 누르면 빈칸으로
            }
        }


        ivHeart.setOnClickListener {
            changeIcon(isHeart, ivHeart)
        }
        ivEmptyHeart.setOnClickListener {
            changeIcon(isHeart, ivHeart)
        }

        setDescription() //Description 셋팅   

        val comment = userInfo?.comment

        val tvComment = findViewById<TextView>(R.id.tv_Comment).apply {
            text = comment
        }

    }

    private fun changeIcon(isHeart: Boolean, heartImage: ImageView) { // 아이콘 변경
        this.isHeart = !isHeart
        heartImage.isVisible = this.isHeart
    }

    private fun setDescription() {

        val description = userInfo?.description
        val tvDescription = findViewById<TextView>(R.id.tv_Description).apply {
            text = description
        } // 설명
        val view_more = findViewById<TextView>(R.id.tv_ViewMore) // 더보기
        val close_Text = findViewById<TextView>(R.id.tv_CloseDescription) //접기


        setViewMore(tvDescription, view_more, close_Text)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { //백버튼 구현
        return when (item.itemId) {
            android.R.id.home -> {
                saveData()
                finish()
                true
            }

            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    //    private fun addCommentDialog(){ // 댓글 팝업창
//        val editText = EditText(this).apply {
//            hint = "댓글달기"
//        }
//        AlertDialog.Builder(this).apply {
//            setView(editText)
//            setNegativeButton("취소"){dialogInterface,_->dialogInterface.cancel()}
//            setPositiveButton("추가"){_,_->
//                if(editText.text.isNullOrEmpty() || editText.text.trim() == "") return@setPositiveButton else addComment(editText.text.toString())
//
//            }
//            show()
//        }
//    }
    private fun addComment(text: String) { //댓글 달기

        val id = userInfo?.id
        val tvComment = findViewById<TextView>(R.id.tv_Comment)
        saveComment += "[$id]  $text\n"

        tvComment.append("\n[$id] $text")
    }

    private fun setViewMore(
        contentTextView: TextView,
        viewMoreTextView: TextView,
        closeTextView: TextView
    ) {
        // getEllipsisCount()을 통한 더보기 표시 및 구현
        contentTextView.post {
            val lineCount = contentTextView.layout.lineCount
            if (lineCount > 0) {
                if (contentTextView.layout.getEllipsisCount(lineCount - 1) > 0) {
                    // 더보기 표시
                    viewMoreTextView.isVisible = true

                    // 더보기, 접기 클릭 이벤트
                    viewMoreTextView.setOnClickListener {
                        contentTextView.maxLines = Int.MAX_VALUE
                        viewMoreTextView.isVisible = false
                        closeTextView.isVisible = true
                    }
                    // 접기 표시
                    closeTextView.setOnClickListener {
                        contentTextView.maxLines = 1
                        viewMoreTextView.isVisible = true
                        closeTextView.isVisible = false
                    }
                }
            }
        }
    }

    private fun showCommentWindow() { //EditText , directIcon 보여주기
        val et_Comment = findViewById<EditText>(R.id.et_Comment)
        val iv_Send = findViewById<ImageView>(R.id.iv_Send)
        et_Comment.isVisible = !et_Comment.isVisible
        iv_Send.isVisible = !iv_Send.isVisible
    }

    override fun onResume() {
        getSaveData()
        super.onResume()
    }

    override fun onDestroy() {
        saveData()
        super.onDestroy()
    }

    private fun saveData() { // 데이터 저장
        getSharedPreferences(USER_INFO, Context.MODE_PRIVATE).edit {
            putBoolean("isHeart", isHeart)
            putString("saveComment", saveComment)
            //clear()
            //remove("saveComment")
            apply()
        }
    }

    private fun getSaveData() { //저장된 데이터 가져오기
        val tvComment = findViewById<TextView>(R.id.tv_Comment)
        getSharedPreferences(USER_INFO, Context.MODE_PRIVATE)?.run {
            isHeart = getBoolean("isHeart", false)
            saveComment = getString("saveComment", "").toString()
            //saveComment = ""
        }
        val ivHeart = findViewById<ImageView>(R.id.iv_Heart)
        val ivEmptyHeart = findViewById<ImageView>(R.id.iv_EmptyHeart)
        if (isHeart) ivHeart.isVisible = true else ivEmptyHeart.isVisible = true
        tvComment.append(saveComment)
    }
}