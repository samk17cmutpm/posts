package com.post.presentation.sales_sign_in

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.Button
import android.widget.EditText
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.post.R
import com.post.di.repositories.DaggerRepositoryComponent
import com.post.presentation.BaseActivity
import javax.inject.Inject

class SalesSignInActivity : BaseActivity(), SalesSignInContract.View {

    @Inject
    lateinit var mPresenter: SalesSignInContract.Presenter

    @BindView(R.id.sales_sign_in_email_ed)
    lateinit var mSalesSignInEmailEd: EditText

    @BindView(R.id.sales_sign_in_password_ed)
    lateinit var mSalesSignInPasswordEd: EditText

    @BindView(R.id.sales_sign_in_bt)
    lateinit var mSalesSignInButton: Button

    @OnClick(R.id.sales_sign_in_bt)
    fun signIn() {
        if (validateInputs()) {
            mPresenter.signInWithFlowable(
                    email = mSalesSignInEmailEd.text.toString(),
                    password = mSalesSignInPasswordEd.text.toString()
            )
        }
    }

    @BindView(R.id.toolbar)
    lateinit var mToolbar: Toolbar

    override fun initComponent() {
        val mRepositoryComponent = DaggerRepositoryComponent.builder().build()
        DaggerSalesSignInComponent.builder()
                .repositoryComponent(mRepositoryComponent)
                .salesSignInModule(SalesSignInModule((this)))
                .build().inject(this)
    }

    override fun initUI() {
        initToolBar(mToolbar, getString(R.string.sales_sign_in_title), 0)
    }

    override fun initData() {

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
