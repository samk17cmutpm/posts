package com.post.data.source

import com.post.data.request_params.SalesSignInParams
import com.post.data.responses.Sale
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Response

/**
 * Created by sam_nguyen on 1/18/18.
 */
interface SalesDataSource {
    fun signIn(salesSignInParams: SalesSignInParams): Observable<Response<Sale>>
    fun signInWithFlowable(salesSignInParams: SalesSignInParams) : Flowable<Response<Sale>>
}