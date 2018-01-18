package com.post.data.repositories

import com.post.data.net.RestApi
import com.post.data.net.ServiceGenerator
import com.post.domain.repositories.PostRepository
import com.post.data.responses.Post
import io.reactivex.Observable
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by sam_nguyen on 1/11/18.
 */
class PostDataRepository @Inject constructor(): PostRepository {

    val mRestApi = ServiceGenerator.createService(RestApi::class.java)

    override fun fetchPost(): Observable<List<Post>>{
        return mRestApi.fetchPost()
    }
}