package com.post.data.request_params

import com.google.gson.annotations.SerializedName
import com.post.domain.UseCase

/**
 * Created by sam_nguyen on 1/18/18.
 */
data class SalesSignInParams (
        @field:SerializedName("email")
        val email: String? = null,
        @field:SerializedName("password")
        val password: String? = null
) : UseCase.RequestValues