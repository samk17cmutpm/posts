package com.post.data.responses

import com.google.gson.annotations.SerializedName

data class Store(

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("info")
	val info: String? = null
)