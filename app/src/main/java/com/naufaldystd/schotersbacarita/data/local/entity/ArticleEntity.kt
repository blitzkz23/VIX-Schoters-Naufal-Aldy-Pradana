package com.naufaldystd.schotersbacarita.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArticleEntity(
	@PrimaryKey
	val id: Int? = null,
	val title: String,
	val author: String,
	val description: String,
	val urlToImage:String,
	val publishedAt: String,
	val url: String,
	val isFavorite : Boolean

)
