package com.example.sns

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val toolBar = findViewById<Toolbar>(R.id.tb_ToolBar)
        toolBar.apply {
            title = "Detail"
            setSupportActionBar(this)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val commentImage = findViewById<ImageView>(R.id.iv_AddComment)

        commentImage.setOnClickListener {//코멘트 이미지 눌렀을 때 다이얼로그
            addCommentDialog()
        }
        setDescription() //Description 셋팅   

    }
    private fun setDescription(){
        //TODO 사진 설명 메인액티비티에서 받아 올 예정
        val description = findViewById<TextView>(R.id.tv_Description) // 설명
        val view_more = findViewById<TextView>(R.id.tv_ViewMore) // 더보기
        val close_Text = findViewById<TextView>(R.id.tv_CloseDescription) //접기
        description.text = "dummyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy"
        setViewMore(description,view_more,close_Text)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { //백버튼 구현
        return when(item.itemId){
            android.R.id.home -> {
                finish()
                true
            }
            else->{
                super.onOptionsItemSelected(item)
            }
        }
    }
    private fun addCommentDialog(){ // 댓글 팝업창
        val editText = EditText(this).apply {
            hint = "댓글달기"
        }
        AlertDialog.Builder(this).apply {
            setView(editText)
            setNegativeButton("취소"){dialogInterface,_->dialogInterface.cancel()}
            setPositiveButton("추가"){_,_->
                if(editText.text.isNullOrEmpty() || editText.text.trim() == "") return@setPositiveButton else addComment(editText.text.toString())

            }
            show()
        }
    }
    private fun addComment(text:String){ //댓글 달기
        val comment = findViewById<TextView>(R.id.tv_Comment)
        comment.append("id "+text + "\n")
            //TODO id 메인액티비티에서 받아 올 예정
    }
    private fun setViewMore(contentTextView: TextView, viewMoreTextView: TextView, closeTextView :TextView) {
        // getEllipsisCount()을 통한 더보기 표시 및 구현
        contentTextView.post {
            val lineCount = contentTextView.layout.lineCount
            if (lineCount > 0) {
                if (contentTextView.layout.getEllipsisCount(lineCount - 1) > 0) {
                    // 더보기 표시
                    viewMoreTextView.visibility = View.VISIBLE

                    // 더보기, 접기 클릭 이벤트
                    viewMoreTextView.setOnClickListener {
                        contentTextView.maxLines = Int.MAX_VALUE
                        viewMoreTextView.visibility = View.GONE
                        closeTextView.visibility = View.VISIBLE
                    }
                    // 접기 표시
                    closeTextView.setOnClickListener {
                        contentTextView.maxLines = 1
                        viewMoreTextView.visibility = View.VISIBLE
                        closeTextView.visibility = View.GONE
                    }
                }
            }
        }
    }
}