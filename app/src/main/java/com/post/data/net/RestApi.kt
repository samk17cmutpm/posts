package com.post.data.net

import com.post.entity.Post
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by sam_nguyen on 1/11/18.
 */
interface RestApi {
    @GET("posts")
    fun fetchPost() : Observable<Response<List<Post>>>
}