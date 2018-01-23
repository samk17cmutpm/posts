package com.post.presentation.sales_sign_in

import com.post.data.repositories.SalesDataRepository
import com.post.domain.interactors.SalesSignInInteractor
import com.post.domain.interactors.SalesSignInWithFlowableInteractor
import dagger.Module
import dagger.Provides

/**
 * Created by sam_nguyen on 1/17/18.
 */
@Module
class SalesSignInModule constructor(private val mView: SalesSignInContract.View) {

    @Provides
    fun providesSalesSignInPresenter(mSalesSignInInteractor: SalesSignInInteractor, mSalesSignInWithFlowableInteractor: SalesSignInWithFlowableInteractor) : SalesSignInContract.Presenter {
        return SalesSignInPresenter(
                mView = mView,
                mSalesSignInInteractor = mSalesSignInInteractor,
                mSalesSignInWithFlowableInteractor = mSalesSignInWithFlowableInteractor)
    }

    @Provides
    fun providesSalesSignInView() : SalesSignInContract.View {
        return mView
    }

    @Provides
    fun providesSalesSignInInteractor(salesDataRepository: SalesDataRepository) : SalesSignInInteractor {
        return SalesSignInInteractor(mSaleRepository = salesDataRepository)
    }

    @Provides
    fun providesSalesSignInWithFlowableInteractor(salesDataRepository: SalesDataRepository) : SalesSignInWithFlowableInteractor {
        return SalesSignInWithFlowableInteractor(mSaleRepository = salesDataRepository)
    }

}