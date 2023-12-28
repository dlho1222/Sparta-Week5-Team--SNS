package com.example.sns

object PostList {

    private val list = mutableListOf<Post>()

    init {

        add(
            Post(
                R.drawable.gogo_mini,
                R.drawable.gogo,
                "날씨가 슬슬 추워진다",
                "goyounjung",
                "[한나]  패딩 얼마주고 삼?",
                "Go Youn Jung",
                "고윤정",
                "ISTP",
                "지나는 자리마다 모가지가 떨어져 내린다고 하여 낙수. 아름답지 않으냐?"

            )
        )
        add(
            Post(
                R.drawable.gogo_mini,
                R.drawable.gogo2,
                "을왕리에서 보낸 좋은사람들과 좋은자리 좋은시간 다 아는사람들이구만",
                "goyounjung",
                "[SANTA]  모자 정보좀요~",
                "Go Youn Jung",
                "고윤정",
                "ISTP",
                "지나는 자리마다 모가지가 떨어져 내린다고 하여 낙수. 아름답지 않으냐?"

            )
        )
        add(
            Post(
                R.drawable.son_mini,
                R.drawable.son,
                "너.. 내가 장사하는 사람으로 보여? 너 납치된거야..",
                "sonsukku",
                "[도리안]  ?",
                "Son Suk Ku",
                "손석구",
                "INFJ",
                "네 눈에도 내가 한심해?"

            )
        )
        add(
            Post(
                R.drawable.swings_mini,
                R.drawable.swings,
                "혹시 돈까스 좋아해요? 암더 킹 문스윙스!",
                "itsjustswings",
                "[앤]  ?",
                "Moon ji hoon",
                "문지훈",
                "ESTP",
                "우사인 봁, 왜 세상에서 가장 달리기 빠른 사람인지 알아요? 끝까지 갔기 때문이에요."

            )
        )

    }
    fun get(index: Int): Post {
        return list[index]
    }

    private fun add(post: Post) {
        list.add(post)
    }
    fun updateHeart(id:String , isHeart:Boolean){
        list.find { id == "Username" }
    }
}