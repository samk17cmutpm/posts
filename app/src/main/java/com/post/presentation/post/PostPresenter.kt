package com.post.presentation.post

import com.post.domain.interactors.FetchingPostInteractor

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
//        mFetchingPostInteractor.run(object : OnlyFetchDataConsumer<List<Post>>() {
//            override fun accept(t: Response<List<Post>>?) {
//                mView.showIndicator(active = false)
//            }
//        }, FetchingPostInteractor.RequestValues())
    }
}