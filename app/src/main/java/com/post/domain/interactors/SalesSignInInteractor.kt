package com.post.domain.interactors

import com.post.domain.UseCase
import com.post.domain.repositories.SalesRepository
import com.post.entity.SalesEntity
import io.reactivex.Observable

/**
 * Created by sam_nguyen on 1/17/18.
 */
class SalesSignInInteractor constructor(private val mSaleRepository: SalesRepository) : UseCase<SalesSignInInteractor.RequestValues, SalesEntity>() {

    override fun buildUseCaseObservable(requestValues: SalesSignInInteractor.RequestValues): Observable<SalesEntity> {
        return mSaleRepository.signIn(email = requestValues.email!!, password = requestValues.password!!)
    }

    data class RequestValues(val email: String? = null, val password: String? = null) : UseCase.RequestValues

}