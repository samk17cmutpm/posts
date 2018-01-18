package com.post.data.source.remote

import com.post.data.net.RestApi
import com.post.data.net.ServiceGenerator
import com.post.data.request_params.SalesSignInParams
import com.post.data.responses.Sale
import com.post.data.source.SalesDataSource
import io.reactivex.Observable
import retrofit2.Response

/**
 * Created by sam_nguyen on 1/18/18.
 */
class SalesDataSourceRemote : SalesDataSource {

    val mRestApi = ServiceGenerator.createService(RestApi::class.java)

    override fun signIn(salesSignInParams: SalesSignInParams): Observable<Response<Sale>> {
        return mRestApi.signIn(salesSignInParams)
    }
}