package com.post.domain.repositories

import com.post.entity.SalesEntity
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by sam_nguyen on 1/17/18.
 */
interface SalesRepository {

    /**
     * Sign In
     */
    fun signInWithFlowable(email: String, password: String) : Flowable<SalesEntity>

}