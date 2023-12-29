package com.example.sns

object ReelsList {

    private val list = mutableListOf<Reels>()

    init {

        add(
            Reels(
                R.drawable.yunakim_mini,
                R.drawable.yunakim,
                "yunakim"
            )
        )
        add(
            Reels(
                R.drawable.faker_mini,
                R.drawable.faker,
                "faker"
            )
        )
        add(
            Reels(
                R.drawable.yun_mini,
                R.drawable.yun,
                "top.physical"
            )
        )
        add(
            Reels(
                R.drawable.paik_mini,
                R.drawable.paik,
                "paikscuisine"
            )
        )
        add(
            Reels(
                R.drawable.jyp_mini,
                R.drawable.jyp,
                "asiansoul_jyp"
            )
        )
        add(
            Reels(
                R.drawable.b2_ang_mini,
                R.drawable.b2_ang,
                "b2_ang"
            )
        )
        add(
            Reels(
                R.drawable.gopro_mini,
                R.drawable.gopro,
                "goprokr"
            )
        )
        add(
            Reels(
                R.drawable.yanolja_mini,
                R.drawable.yanolja,
                "yanolja.official"
            )
        )



    }

    fun get(index: Int): Reels {
        return list[index]
    }

    private fun add(reels: Reels) {
        list.add(reels)
    }

}