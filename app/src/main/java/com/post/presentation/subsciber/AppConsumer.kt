package com.post.presentation.subsciber

import io.reactivex.functions.Consumer
import retrofit2.Response

/**
 * Created by sam_nguyen on 1/16/18.
 */
interface AppConsumer<T> : Consumer<T> {
    fun showIndicator();
    fun hideIndicator();
    fun displayErrors(message: String)
}