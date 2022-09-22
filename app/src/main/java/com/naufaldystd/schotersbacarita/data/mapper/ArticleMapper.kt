package com.naufaldystd.schotersbacarita.data.mapper

import com.naufaldystd.schotersbacarita.data.local.entity.ArticleEntity
import com.naufaldystd.schotersbacarita.domain.model.Article

/**
 * Extension to map entity into domain model for clean architecture data separation purpose.
 *
 * @return Article
 */
fun ArticleEntity.toArticle(): Article {
	return Article(
		title = title,
		author = author,
		description = description,
		urlToImage = urlToImage,
		publishedAt = publishedAt
	)
}