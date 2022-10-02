package com.naufaldystd.schotersbacarita.data.remote.response

import com.google.gson.annotations.SerializedName

data class ArticlesItem(

	@field:SerializedName("publishedAt")
	val publishedAt: String,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("urlToImage")
	val urlToImage: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("url")
	val url: String,
)