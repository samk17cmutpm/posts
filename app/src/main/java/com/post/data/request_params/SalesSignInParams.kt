package com.post.data.request_params

import com.google.gson.annotations.SerializedName
import com.post.domain.ObservableUseCase

/**
 * Created by sam_nguyen on 1/18/18.
 */
data class SalesSignInParams (
        @field:SerializedName(value = "email")
        val email: String? = null,
        @field:SerializedName(value = "password")
        val password: String? = null
) : ObservableUseCase.RequestValues