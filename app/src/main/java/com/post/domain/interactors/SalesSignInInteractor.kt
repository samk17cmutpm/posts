package com.post.domain.interactors

import com.post.data.request_params.SalesSignInParams
import com.post.domain.UseCase
import com.post.domain.repositories.SalesRepository
import com.post.entity.SalesEntity
import io.reactivex.Observable

/**
 * Created by sam_nguyen on 1/17/18.
 */
class SalesSignInInteractor constructor(private val mSaleRepository: SalesRepository) : UseCase<SalesSignInParams, SalesEntity>() {

    override fun buildUseCaseObservable(salesSignInParams: SalesSignInParams): Observable<SalesEntity> {
        return mSaleRepository.signIn(salesSignInParams)
    }

}