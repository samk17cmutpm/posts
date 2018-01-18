package com.post.domain.repositories

import com.post.data.responses.Post
import io.reactivex.Observable
import retrofit2.Response

/**
 * Created by sam_nguyen on 1/11/18.
 */
interface PostRepository {

    /**
     * Fetching Post
     */
    fun fetchPost() : Observable<List<Post>>
}