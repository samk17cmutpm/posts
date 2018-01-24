package com.post.data.utils

import com.post.data.net.APIError
import com.post.data.net.ServiceGenerator
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Response
import java.io.IOException


/**
 * Created by sam_nguyen on 1/23/18.
 */
class DomainUtils {
    companion object {
        fun <T> parseError(response: Response<T>) : APIError {
            val annotation: Array<Annotation> = Array(0, { i -> object : Annotation {} })
            val converter: Converter<ResponseBody, APIError> = ServiceGenerator.retrofit().responseBodyConverter(
                    APIError::class.java,
                    annotation
            )

            val error: APIError
            try {
                error = converter.convert(response.errorBody())
            } catch (e: IOException) {
                return APIError()
            }

            return error
        }
    }
}