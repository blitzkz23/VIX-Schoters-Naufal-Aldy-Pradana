package com.naufaldystd.schotersbacarita.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
	val id: Int,
	val title: String,
	val author: String,
	val description: String,
	val urlToImage: String,
	val publishedAt: String,
	val url: String,
	var isFavorite: Boolean,
	var isFeatured: Boolean
): Parcelable
