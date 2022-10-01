package com.naufaldystd.schotersbacarita.domain.model

data class Article(
	val title: String,
	val author: String,
	val description: String,
	val urlToImage: String,
	val publishedAt: String,
	val url: String,
	val isFavorite: Boolean,
	var isFeatured: Boolean
)
