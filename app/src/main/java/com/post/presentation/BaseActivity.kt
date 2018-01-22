package com.post.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.TextView
import com.post.R
import kotlinx.android.synthetic.main.toolbar.view.*

/**
 * Created by sam_nguyen on 1/12/18.
 */
open class BaseActivity : AppCompatActivity(), BaseViewActions {
    override fun initToolBar(toolbar: Toolbar, title: String, icon: Int) {
        setSupportActionBar(toolbar)
        toolbar.setContentInsetsAbsolute(0, 0)
        if (icon != 0) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            toolbar.setNavigationIcon(icon)
        }
        if (!title.isEmpty()) {
            val titleToolBarTextView = toolbar.findViewById<TextView>(R.id.toolbar_title)
            titleToolBarTextView.text = title
        }
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}