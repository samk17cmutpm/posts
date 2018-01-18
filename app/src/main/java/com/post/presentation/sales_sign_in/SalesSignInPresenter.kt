package com.post.presentation.sales_sign_in

import com.post.data.request_params.SalesSignInParams
import com.post.domain.interactors.SalesSignInInteractor
import com.post.data.responses.Sale
import com.post.presentation.subsciber.OnlyFetchDataConsumer

/**
 * Created by sam_nguyen on 1/17/18.
 */
class SalesSignInPresenter constructor(
        val mView: SalesSignInContract.View,
        val mSalesSignInInteractor: SalesSignInInteractor) : SalesSignInContract.Presenter {

    override fun signIn(email: String, password: String) {
        val salesSignInParams = SalesSignInParams(email = email, password = password)
        mSalesSignInInteractor.run(object : OnlyFetchDataConsumer<Sale>() {
        }, salesSignInParams)
    }

    override fun detachView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}