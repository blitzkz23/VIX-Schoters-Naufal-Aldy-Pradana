package com.naufaldystd.schotersbacarita.data.mapper

import com.naufaldystd.schotersbacarita.data.local.entity.ArticleEntity
import com.naufaldystd.schotersbacarita.data.remote.response.ArticlesItem
import com.naufaldystd.schotersbacarita.data.remote.response.NewsResponse
import com.naufaldystd.schotersbacarita.domain.model.Article


/**
 * Extension to map responses of news to local entity.
 *
 * @return
 */
fun ArticlesItem.toArticleEntities(): ArticleEntity =
	ArticleEntity(
		title = title,
		author = author,
		description = description,
		urlToImage = urlToImage,
		publishedAt = publishedAt,
		url = url,
		isFavorite = false
	)


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
		publishedAt = publishedAt,
		url = url,
		isFavorite = false
	)
}

/**
 * Extension to map article model to article entity.
 *
 * @return
 */
fun Article.toArticleEntity(): ArticleEntity {
	return ArticleEntity(
		title = title,
		author = author,
		description = description,
		urlToImage = urlToImage,
		publishedAt = publishedAt,
		url = url,
		isFavorite = isFavorite
	)
}