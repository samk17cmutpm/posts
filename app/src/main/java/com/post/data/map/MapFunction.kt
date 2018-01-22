package com.post.data.map

import io.reactivex.functions.Function
import retrofit2.Response

/**
 * Created by sam_nguyen on 1/19/18.
 */
abstract class MapFunction<P, E> : Function<Response<P>, E> {
    override fun apply(t: Response<P>): E {
        if (t.isSuccessful)
            return success(t)
        else
            return failed()
    }

    abstract fun success(t: Response<P>) : E

    abstract fun failed() : E

}