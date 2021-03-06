package com.post.presentation.sales_sign_in

import com.post.data.repositories.SalesDataRepository
import com.post.domain.interactors.SalesSignInInteractor
import dagger.Module
import dagger.Provides

/**
 * Created by sam_nguyen on 1/17/18.
 */
@Module
class SalesSignInModule constructor(private val mView: SalesSignInContract.View) {

    @Provides
    fun providesSalesSignInPresenter(mSalesSignInInteractor: SalesSignInInteractor) : SalesSignInContract.Presenter {
        return SalesSignInPresenter(mView, mSalesSignInInteractor)
    }

    @Provides
    fun providesSalesSignInView() : SalesSignInContract.View {
        return mView
    }

    @Provides
    fun providesSalesSignInInteractor(salesDataRepository: SalesDataRepository) : SalesSignInInteractor {
        return SalesSignInInteractor(salesDataRepository)
    }

}