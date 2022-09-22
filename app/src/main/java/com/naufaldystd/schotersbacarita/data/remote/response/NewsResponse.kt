package com.naufaldystd.schotersbacarita.data.remote.response

import com.google.gson.annotations.SerializedName

data class NewsResponse(

	@field:SerializedName("articles")
	val articles: List<ArticlesItem?>,
)