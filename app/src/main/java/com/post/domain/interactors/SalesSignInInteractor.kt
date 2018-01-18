package com.post.domain.interactors

import com.post.data.request_params.SalesSignInParams
import com.post.domain.UseCase
import com.post.domain.repositories.SalesRepository
import com.post.data.responses.Sale
import io.reactivex.Observable
import retrofit2.Response

/**
 * Created by sam_nguyen on 1/17/18.
 */
class SalesSignInInteractor constructor(private val mSaleRepository: SalesRepository) : UseCase<SalesSignInParams, Sale>() {

    override fun buildUseCaseObservable(salesSignInParams: SalesSignInParams): Observable<Response<Sale>> {
        return mSaleRepository.signIn(salesSignInParams)
    }

}