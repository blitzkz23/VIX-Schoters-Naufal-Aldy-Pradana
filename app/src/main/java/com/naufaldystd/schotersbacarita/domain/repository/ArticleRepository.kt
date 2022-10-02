package com.naufaldystd.schotersbacarita.domain.repository

import com.naufaldystd.schotersbacarita.domain.model.Article
import com.naufaldystd.schotersbacarita.util.Resource
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {

	/**
	 * Get articles from either network or local
	 *
	 * @param fetchFromRemote
	 * @param query
	 * @return
	 */
	suspend fun getArticles(
		fetchFromRemote: Boolean,
		query: String
	): Flow<Resource<List<Article>>>

	suspend fun getBookmarkedArticle(): Resource<List<Article>>

	fun setBookmarkNews(article: Article, newState: Boolean)

	suspend fun getArticleById(id: Int): Resource<Article>
}