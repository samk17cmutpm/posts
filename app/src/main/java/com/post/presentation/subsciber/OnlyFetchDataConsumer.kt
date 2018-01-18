package com.post.presentation.subsciber

import retrofit2.Response

/**
 * Created by sam_nguyen on 1/16/18.
 */
abstract class OnlyFetchDataConsumer<T> : AppConsumer<T> {

    init {
    }

    override fun accept(t: T?) {

    }

    override fun showIndicator() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideIndicator() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun displayErrors(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}