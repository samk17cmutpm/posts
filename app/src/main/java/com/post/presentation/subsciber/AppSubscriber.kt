package com.post.presentation.subsciber

import com.post.data.exceptions.RemoteDataThrowable
import com.post.presentation.BaseViewActions
import io.reactivex.subscribers.DisposableSubscriber

/**
 * Created by sam_nguyen on 1/24/18.
 */
abstract class AppSubscriber<T> constructor(private val baseViewActions: BaseViewActions): DisposableSubscriber<T>() {
    override fun onComplete() {

    }

    override fun onNext(t: T) {

    }

    override fun onError(throwable: Throwable?) {
        val remoteDataThrowable = throwable as RemoteDataThrowable
        baseViewActions.handleStatusCodeError(remoteDataThrowable.remoteStatusCode)
    }
}