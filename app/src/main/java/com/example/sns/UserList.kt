package com.example.sns

object UserList {

    private val list = mutableListOf<User>()

    init {

        add(
            User(
                R.drawable.testimg,
                R.drawable.gogo,
                "[사용자 아이디] 슬슬 추워진다..",
                "Username",
                "[한나] 패딩 얼마주고 삼?",
            )
        )
        add(
            User(
                R.drawable.testimg,
                R.drawable.gogo2,
                "[사용자 아이디] 을왕리에서 보낸 좋은사람들과 좋은자리 좋은시간 다 아는사람들이구만..",
                "Username",
                "[SANTA] 모자 정보좀요~",
            )
        )
        add(
            User(
                R.drawable.testimg,
                R.drawable.son,
                "[사용자 아이디] 내가 장사하는 사람으로 보여? 너 납치된거야..",
                "Username",
                "[도리안] ?",
            )
        )
        add(
            User(
                R.drawable.testimg,
                R.drawable.swings,
                "[사용자 아이디] 혹시 돈까스 좋아해요?",
                "Username",
                "[앤] ?",
            )
        )

    }
    fun get(index: Int): User {
        return list[index]
    }

    private fun add(user: User) {
        list.add(user)
    }
}