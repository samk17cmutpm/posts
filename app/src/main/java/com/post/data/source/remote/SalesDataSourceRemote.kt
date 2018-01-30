package com.post.data.source.remote

import com.post.data.net.SalesService
import com.post.data.net.ServiceGenerator
import com.post.data.request_params.SalesSignInParams
import com.post.data.responses.Sale
import com.post.data.source.SalesDataSource
import io.reactivex.Flowable
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by sam_nguyen on 1/18/18.
 */
class SalesDataSourceRemote @Inject constructor() : SalesDataSource {
    private val mSalesService: SalesService = ServiceGenerator.createService(SalesService::class.java)
    override fun signInWithFlowable(salesSignInParams: SalesSignInParams): Flowable<Response<Sale>> {
        return mSalesService.signInWithFlowable(salesSignInParams)
    }
}