package com.post.presentation.sales_sign_in

import com.post.domain.interactors.SalesSignInInteractor
import com.post.entity.SalesEntity
import com.post.presentation.subsciber.OnlyFetchDataConsumer

/**
 * Created by sam_nguyen on 1/17/18.
 */
class SalesSignInPresenter constructor(
        val mView: SalesSignInContract.View,
        val mSalesSignInInteractor: SalesSignInInteractor) : SalesSignInContract.Presenter {

    override fun signIn(email: String, password: String) {
        val requestValues = SalesSignInInteractor.RequestValues(email = email, password = password)
        mSalesSignInInteractor.run(object : OnlyFetchDataConsumer<SalesEntity>() {
            override fun accept(salesEntity: SalesEntity?) {
                super.accept(salesEntity)
            }
        }, requestValues)
    }

    override fun detachView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}