package com.post.presentation.sales_sign_in

import android.os.Bundle
import butterknife.ButterKnife
import com.post.R
import com.post.di.repositories.DaggerRepositoryComponent
import com.post.presentation.BaseActivity
import javax.inject.Inject

class SalesSignInActivity : BaseActivity(), SalesSignInContract.View {

    @Inject
    lateinit var mPresenter: SalesSignInContract.Presenter

    override fun initComponent() {
        val mRepositoryComponent = DaggerRepositoryComponent.builder().build()
        DaggerSalesSignInComponent.builder()
                .repositoryComponent(mRepositoryComponent)
                .salesSignInModule(SalesSignInModule((this)))
                .build().inject(this)
    }

    override fun initUI() {
    }

    override fun initData() {
        mPresenter.signIn(email = "thanqminh@gmail.com", password = "Abcd1234")
    }

    override fun signIn(signInStatus: SalesSignInContract.SignInStatus) {
        signInStatus.validate()
    }

    override fun validateInputs(): Boolean {
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sales_sign_in)
        ButterKnife.bind(this)
        initComponent()
        initUI()
        initData()
    }

    class SignInSuccess : SalesSignInContract.SignInStatus {
        override fun validate() {
        }
    }

    class SignInFailed : SalesSignInContract.SignInStatus {
        override fun validate() {
        }
    }

    data class SignInForm(val email: String? = null,
                          val password: String? = null
    ) : SalesSignInContract.SignInData
 }
