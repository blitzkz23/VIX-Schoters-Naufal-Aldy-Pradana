package com.naufaldystd.schotersbacarita.data.mapper

import com.naufaldystd.schotersbacarita.data.local.entity.ArticleEntity
import com.naufaldystd.schotersbacarita.data.remote.response.ArticlesItem
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
		isFavorite = false,
		isFeatured = false,
	)


/**
 * Extension to map entity into domain model for clean architecture data separation purpose.
 *
 * @return Article
 */
fun ArticleEntity.toArticle(): Article {
	return Article(
		id = id ?: 0,
		title = title,
		author = author ?: "Penulis Anon",
		description = description ?: "Artikel ini tidak memiliki deskripsi",
		urlToImage = urlToImage ?: "https://images.unsplash.com/photo-1523730205978-59fd1b2965e3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=754&q=80",
		publishedAt = publishedAt,
		url = url,
		isFavorite = false,
		isFeatured = false
	)
}

/**
 * Extension to map article model to article entity.
 *
 * @return
 */
fun Article.toArticleEntity(): ArticleEntity {
	return ArticleEntity(
		id = id,
		title = title,
		author = author,
		description = description,
		urlToImage = urlToImage,
		publishedAt = publishedAt,
		url = url,
		isFavorite = isFavorite,
		isFeatured = isFeatured
	)
}