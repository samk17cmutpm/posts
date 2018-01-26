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

    abstract override fun onNext(t: T)

    override fun onError(throwable: Throwable?) {
        if (throwable is RemoteDataThrowable) {
            baseViewActions.handleStatusCodeError(throwable.remoteStatusCode)
            onFailure(throwable.message!!)
        } else {
            baseViewActions.handleInternetException(throwable?.message!!)
        }
    }

    abstract fun onFailure(message: String)
}