package com.post.presentation.sales_sign_in

import com.post.domain.interactors.SalesSignInInteractor
import com.post.domain.interactors.SalesSignInWithFlowableInteractor
import com.post.entity.SalesEntity
import io.reactivex.observers.DisposableObserver
import io.reactivex.subscribers.DisposableSubscriber

/**
 * Created by sam_nguyen on 1/17/18.
 */
class SalesSignInPresenter constructor(
        val mView: SalesSignInContract.View,
        val mSalesSignInInteractor: SalesSignInInteractor,
        val mSalesSignInWithFlowableInteractor: SalesSignInWithFlowableInteractor) : SalesSignInContract.Presenter {
    override fun signInWithFlowable(email: String, password: String) {
        val requestValues = SalesSignInWithFlowableInteractor.RequestValues(email = email, password = password)
        mSalesSignInWithFlowableInteractor.run(
                object : DisposableSubscriber<SalesEntity>() {
                    override fun onComplete() {
                    }

                    override fun onNext(t: SalesEntity?) {
                    }

                    override fun onError(t: Throwable?) {
                    }

                },
                requestValues
        )
    }

    override fun signIn(email: String, password: String) {
        val requestValues = SalesSignInInteractor.RequestValues(email = email, password = password)
        mSalesSignInInteractor.run(
                object : DisposableObserver<SalesEntity>() {
                    override fun onComplete() {
                    }

                    override fun onNext(t: SalesEntity) {

                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                },
                requestValues
        )
    }

    override fun detachView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}