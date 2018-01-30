package com.post.data.net

import com.post.data.request_params.SalesSignInParams
import com.post.data.responses.Sale
import io.reactivex.Flowable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by sam_nguyen on 1/29/18.
 */
interface SalesService {
    @POST(value = "api/v1/sales/sign_in")
    fun signInWithFlowable(@Body signInParams: SalesSignInParams) : Flowable<Response<Sale>>
}