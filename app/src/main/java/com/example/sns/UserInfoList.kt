package com.example.sns

object UserInfoList {
    private val list = mutableListOf<UserInfo>()
    init {
        add(
            UserInfo(
                "aaa@naver.com",
                "김경식",
                "1234asdf!",
                "공연때문에 부재중",
                "산책,등산,공연투어",
                "Infp",
                R.drawable.testimg
            )
        )
        add(
            UserInfo(
                "sda234scc@gmail.com",
                "박상우",
                "asdfASDFa23",
                "아무것도 몰라요",
                "수영, 음악 듣기, 마술, 종이접기",
                "ENTP",
                R.drawable.testimg
            )
        )
        add(
            UserInfo(
                "32142312@hanmail.net",
                "유영국",
                "1234asdf!#!",
                "열심히 따라가겠습니다",
                "회화, 애완동물, 우취, 악기 연주,",
                "INFP",
                R.drawable.testimg
            )
        )
        add(
            UserInfo(
                "aa23123a@naver.com",
                "이호",
                "hhhhhh",
                "잘 부탁드립니다.",
                "도예, 퍼즐, 조각, 바느질",
                "ESFJ",
                R.drawable.testimg
            )
        )

    }

    fun get(index: Int):UserInfo{
        return list[index]
    }

    fun add(userInfo: UserInfo) {
        list.add(userInfo)
    }
    fun delete(email: String){
        list.find{target->
            target.email == email
        }.let{
            list.remove(it)
        }
    }
    fun findUserInfoWithEmail(email:String?): UserInfo? {
        return list.find {
            it.email == email
        }
    }

    fun findNameWithEmail(email:String?) : String {
        val index = list.indexOfFirst {
            it.email == email
        }
        return list[index].name
    }

    fun modifyEmail(email: String,changedEmail:String) {
        val index = list.indexOfFirst {
            it.email == email
        }
        list[index].email = changedEmail
    }
    fun modifyName(email: String,changedName:String) {
        val index = list.indexOfFirst {
            it.email == email
        }
        list[index].name = changedName
    }
    fun modifyPassword(email: String,changedPassword:String) {
        val index = list.indexOfFirst {
            it.email == email
        }
        list[index].password = changedPassword
    }
}