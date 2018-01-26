package com.post.domain.interactors

import com.post.domain.FlowableUseCase
import com.post.domain.repositories.SalesRepository
import com.post.entity.SalesEntity
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by sam_nguyen on 1/22/18.
 */
class SalesSignInInteractor @Inject constructor(val mSaleRepository: SalesRepository) : FlowableUseCase<SalesSignInInteractor.RequestValues, SalesEntity>() {
    override fun buildUseCaseObservable(requestValues: RequestValues): Flowable<SalesEntity> {
        return mSaleRepository.signInWithFlowable(requestValues.email!!, requestValues.password!!)
    }

    class RequestValues(val email: String? = null, val password: String? = null) : FlowableUseCase.RequestValues
}