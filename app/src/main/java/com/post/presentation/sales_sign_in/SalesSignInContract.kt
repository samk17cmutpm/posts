package com.post.presentation.sales_sign_in

import com.post.presentation.BasePresenter
import com.post.presentation.BaseView

/**
 * Created by sam_nguyen on 1/17/18.
 */
interface SalesSignInContract {

    interface View : BaseView {
        fun signIn(signInStatus: SignInStatus)
        fun validateInputs() : Boolean
    }

    interface Presenter : BasePresenter<View> {
        fun signIn(email: String, password: String)
    }

    interface SignInStatus {
        fun validate()
    }

    interface SignInData {

    }
}