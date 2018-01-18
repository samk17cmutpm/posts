package com.post.presentation.post

import com.post.data.responses.Post
import com.post.presentation.BasePresenter
import com.post.presentation.BaseView

/**
 * Created by sam_nguyen on 1/11/18.
 */
interface PostContract {

    interface View : BaseView {
        fun showPost(posts : List<Post>)
        fun showIndicator(active: Boolean)
    }

    interface Presenter : BasePresenter<View> {
        fun fetchPost()
    }

}