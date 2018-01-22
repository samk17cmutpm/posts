package com.post.presentation

import android.support.v7.widget.Toolbar


/**
 * Created by sam_nguyen on 1/19/18.
 */
interface BaseViewActions {

    /**
     * Init Toolbar
     * @param toolbar
     * @param title
     * @param icon
     */
    fun initToolBar(toolbar: Toolbar, title: String, icon: Int)

}