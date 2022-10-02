package com.naufaldystd.schotersbacarita.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArticleEntity(
	@PrimaryKey
	val id: Int? = null,
	val title: String,
	val author: String? = null,
	val description: String? = null,
	val urlToImage:String? = null,
	val publishedAt: String,
	val url: String,
	val isFavorite : Boolean,
	val isFeatured: Boolean

)
