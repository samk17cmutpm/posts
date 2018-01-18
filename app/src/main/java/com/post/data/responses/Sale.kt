package com.post.data.responses

import com.google.gson.annotations.SerializedName
import com.post.data.responses.Store

data class Sale(
		@field:SerializedName("image")
		val image: String? = null,

		@field:SerializedName("name")
		val name: String? = null,

		@field:SerializedName("id")
		val id: Int? = null,

		@field:SerializedName("store")
		val store: Store? = null,

		@field:SerializedName("email")
		val email: String? = null
)