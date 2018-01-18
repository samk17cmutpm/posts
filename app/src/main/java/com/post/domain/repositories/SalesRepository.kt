package com.post.domain.repositories

import com.post.data.request_params.SalesSignInParams
import com.post.data.responses.Sale
import io.reactivex.Observable
import retrofit2.Response

/**
 * Created by sam_nguyen on 1/17/18.
 */
interface SalesRepository {

    /**
     * Sign In
     */
    fun signIn(salesSignInParams: SalesSignInParams) : Observable<Response<Sale>>

}