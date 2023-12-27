/*
package com.example.sns

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class TransActivity(
    private val transitionMode: TransitionMode = TransitionMode.NONE
) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        onInject(savedInstanceState)
        super.onCreate(savedInstanceState)

        when (transitionMode) {
            TransitionMode.HORIZON -> overridePendingTransition(R.anim.get_in_trans, R.anim.get_none_trans)
            TransitionMode.VERTICAL -> overridePendingTransition(R.anim.get_in_trans, R.anim.get_none_trans)
            else -> Unit
        }
    }

    override fun finish() {
        super.finish()

        when (transitionMode) {
            TransitionMode.HORIZON -> overridePendingTransition(R.anim.get_none_trans, R.anim.get_out_trans)
            TransitionMode.VERTICAL -> overridePendingTransition(R.anim.get_none_trans, R.anim.get_out_trans)
            else -> Unit
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (isFinishing) {
            when (transitionMode) {
                overridePendingTransition(R.anim.get_none_trans, R.anim.get_out_trans)
                else -> Unit
            }
        }
    }

    enum class TransitionMode {
        NONE,
        HORIZON,
        VERTICAL
    }
}*/
