package com.post.data.responses

import com.google.gson.annotations.SerializedName

/**
 * Created by sam_nguyen on 1/11/18.
 */
class Post {
    @SerializedName("userId")
    var userId: Int = 0

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("title")
    lateinit var title: String

    @SerializedName(value = "body")
    lateinit var body: String
}