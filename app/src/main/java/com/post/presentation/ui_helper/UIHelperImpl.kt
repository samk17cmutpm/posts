package com.post.presentation.ui_helper

/**
 * Created by sam_nguyen on 1/16/18.
 */
class UIHelperImpl : UIHelper {
    override fun showErrors(error: Error) {
        error.message()
    }
}