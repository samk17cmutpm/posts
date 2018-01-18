package com.post.data.net

import com.post.data.request_params.SalesSignInParams
import com.post.data.responses.Post
import com.post.data.responses.Sale
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by sam_nguyen on 1/11/18.
 */
interface RestApi {
    @GET(value = "posts")
    fun fetchPost() : Observable<List<Post>>

    @POST(value = "api/v1/sales/sign_in")
    fun signIn(@Body signInParams: SalesSignInParams) : Observable<Response<Sale>>
}