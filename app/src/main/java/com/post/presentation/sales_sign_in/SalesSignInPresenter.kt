package com.post.presentation.sales_sign_in

import android.util.Log
import com.post.data.exceptions.RemoteDataThrowable
import com.post.domain.interactors.SalesSignInInteractor
import com.post.entity.SalesEntity
import com.post.presentation.BaseViewActions
import com.post.presentation.subsciber.AppSubscriber
import javax.inject.Inject

/**
 * Created by sam_nguyen on 1/17/18.
 */
class SalesSignInPresenter @Inject constructor(private val mView: SalesSignInContract.View,
                                               private val mSalesSignInInteractor: SalesSignInInteractor)
    : SalesSignInContract.Presenter {


    override fun signIn(email: String, password: String) {
        val requestValues = SalesSignInInteractor.RequestValues(email, password)
        mSalesSignInInteractor.run(SalesSignInSubscriber(), requestValues)
    }

    override fun detachView() {
        mSalesSignInInteractor.dispose()
    }

    inner class SalesSignInSubscriber : AppSubscriber<SalesEntity>(mView as BaseViewActions) {
        override fun onFailure(message: String) {

        }

        override fun onNext(t: SalesEntity) {

        }
    }
}