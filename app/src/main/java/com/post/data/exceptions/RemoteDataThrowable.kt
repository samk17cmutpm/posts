package com.post.data.exceptions

/**
 * Created by sam_nguyen on 1/24/18.
 */
class RemoteDataThrowable(message: String, val remoteStatusCode: Int) : Throwable(message)