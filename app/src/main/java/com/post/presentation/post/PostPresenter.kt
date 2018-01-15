package com.post.presentation.post

import com.post.domain.interactors.FetchingPostInteractor
import com.post.entity.Post
import com.post.presentation.BaseConsumer

/**
 * Created by sam_nguyen on 1/11/18.
 */
class PostPresenter constructor(
        val mView: PostContract.View,
        val mFetchingPostInteractor: FetchingPostInteractor) : PostContract.Presenter {

    override fun detachView() {
        mFetchingPostInteractor.dispose()
    }

    override fun fetchPost() {
        mView.showIndicator(active = true)
        mFetchingPostInteractor.run(object : BaseConsumer<List<Post>>() {
            override fun onSuccess(data: List<Post>) {
                mView.showIndicator(active = false)
                mView.showPost(data)
            }
        }, FetchingPostInteractor.RequestValues())
    }
}