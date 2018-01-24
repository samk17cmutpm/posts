package com.post.presentation.handle_error

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.post.R
import com.post.presentation.BaseActivity

class HandleErrorActivity : BaseActivity() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, HandleErrorActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handle_error)
    }
}
