package com.post.domain.interactors

import com.post.domain.FlowableUseCase
import com.post.domain.repositories.SalesRepository
import com.post.entity.SalesEntity
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by sam_nguyen on 1/22/18.
 */
class SalesSignInWithFlowableInteractor @Inject constructor(val mSaleRepository: SalesRepository) : FlowableUseCase<SalesSignInWithFlowableInteractor.RequestValues, SalesEntity>() {
    override fun buildUseCaseObservable(requestValues: RequestValues): Flowable<SalesEntity> {
        return mSaleRepository.signInWithFlowable(email = requestValues.email!!, password = requestValues.password!!)
    }

    class RequestValues(val email: String? = null, val password: String? = null) : FlowableUseCase.RequestValues
}