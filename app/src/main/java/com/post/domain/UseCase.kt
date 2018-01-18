package com.post.domain

import com.post.presentation.BaseConsumer
import com.post.presentation.subsciber.AppConsumer
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

/**
 * Created by sam_nguyen on 1/11/18.
 */
abstract class UseCase<Q : UseCase.RequestValues, P> {

    val subscription: CompositeDisposable = CompositeDisposable()

    interface RequestValues

    abstract fun buildUseCaseObservable(requestValues: Q) : Observable<P>

    fun run(consumer: AppConsumer<P>, requestValues: Q) {
        val observable: Observable<P> = this.buildUseCaseObservable(requestValues)
        subscription.add(observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer))
    }

    open fun dispose() {
        subscription.clear()
    }
}