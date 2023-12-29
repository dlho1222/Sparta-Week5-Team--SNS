package com.example.sns

import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible

class DetailActivity : AppCompatActivity() {
    private var isHeart = false //좋아요 상태
    private var postInfo: Post? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val toolBar = findViewById<Toolbar>(R.id.tb_ToolBar)
        val ivComment = findViewById<ImageView>(R.id.iv_AddComment)
        val etComment = findViewById<EditText>(R.id.et_Comment)
        val ivHeart = findViewById<ImageView>(R.id.iv_Heart)

        postInfo = intent.getParcelableExtra<Post>(POST_INFO)
        isHeart = postInfo?.isLike ?: false

        toolBar.apply {
            title = "Detail"
            setSupportActionBar(this)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val ivContents = findViewById<ImageView>(R.id.iv_ContentsImage).apply {
            postInfo?.contentsImage?.let { setImageResource(it) }
        }
        val ivProfile = findViewById<ImageView>(R.id.iv_Profile).apply {
            postInfo?.profile?.let { setImageResource(it) }
        }
        val yourdetail1 = findViewById<TextView>(R.id.tv_Eng_Name).apply {
            postInfo?.EngName?.let { setText(it) }
        }
        val yourdetail2 = findViewById<TextView>(R.id.tv_KR_Name).apply {
            postInfo?.KR_Name?.let { setText(it) }
        }
        val yourdetail3 = findViewById<TextView>(R.id.tv_MBTI).apply {
            postInfo?.MBTI?.let { setText("MBTI : $it") }
        }
        val yourdetail4 = findViewById<TextView>(R.id.tv_Status).apply {
            postInfo?.Status?.let { setText(it) }
        }


        ivComment.setOnClickListener {//코멘트 아이콘 눌렀을 때 commentwindow 보여줌
            showCommentWindow()
        }
        val ivSend = findViewById<ImageView>(R.id.iv_Send)?.apply {//댓글 입력하는 역할
            setOnClickListener {
                if (etComment.text.isNullOrEmpty() || etComment.text.trim() == "") return@setOnClickListener
                addComment(etComment.text.toString())
                etComment.setText("") //다이렉트 아이콘 누르면 빈칸으로
            }
        }


        changeIcon(isHeart,ivHeart)

        ivHeart.setOnClickListener {
            changeIcon(isHeart, ivHeart)
        }

        setDescription() //Description 셋팅   

        val comment = postInfo?.comment

        val tvComment = findViewById<TextView>(R.id.tv_Comment).apply {
            text = comment
        }

    }

    private fun changeIcon(isHeart: Boolean, heartImage: ImageView) { // 아이콘 변경
        this.isHeart = !isHeart
        heartImage.setImageResource(
            if (isHeart) R.drawable.heart else R.drawable.emptyheart
        )

    }

    private fun setDescription() {

        val description = postInfo?.description
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
                finish()
                true
            }

            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun addComment(text: String) { //댓글 달기
        val id = intent.getStringExtra(ID)
        val tvComment = findViewById<TextView>(R.id.tv_Comment)
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

}