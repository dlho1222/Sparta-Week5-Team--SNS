package com.example.sns

data class Content(val id: String, val profile: Int, val img: Int, val description: String?, val comment: String?)

val contentList: MutableList<Content> = mutableListOf(
    Content("goyounjung", R.drawable.testimg, R.drawable.gogo, "슬슬 추워진다..", "[from database] 패딩 얼마주고 삼?"),
    Content("goyounjung", R.drawable.testimg, R.drawable.gogo2, "을왕리에서 보낸 좋은사람들과 좋은자리 좋은시간 다 아는사람들이구만..", "[댓글 사용자 아이디] 모자 정보좀요~"),
    Content("sonsukku", R.drawable.testimg, R.drawable.gogo, "내가 장사하는 사람으로 보여? 너 납치된거야..", "[댓글 사용자 아이디] ?"),
    Content("itsjustswings", R.drawable.testimg, R.drawable.gogo, "혹시 돈까스 좋아해요?", "[댓글 사용자 아이디] ?")
)



data class User(val name: String, val email: String, val pw: String)

val userList: MutableList<User> = mutableListOf(
    User("제갈범수","test1@gmail.com", "test1"),    //인덱스 0번
    User("황보동건","test2@gmail.com", "test2"),    //인덱스 1번 ~
    User("남궁혜윤","test3@gmail.com", "test3"),
    User("선우정아","test4@gmail.com", "test4"),

)