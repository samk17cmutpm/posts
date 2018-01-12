package com.post.presentation.post

import android.util.Log
import com.post.domain.interactors.FetchingPostInteractor
import com.post.domain.repositories.PostRepository
import com.post.entity.Post
import com.post.presentation.BaseConsumer
import javax.inject.Inject

/**
 * Created by sam_nguyen on 1/11/18.
 */
class PostPresenter constructor(val mPostRepository: PostRepository) : PostContract.Presenter {

    private lateinit var mView: PostContract.View

    private var mFetchingPostInteractor: FetchingPostInteractor

    init {
        mFetchingPostInteractor = FetchingPostInteractor(mPostRepository)
    }

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

    override fun attachView(view: PostContract.View) {
        mView = view
    }
}