package com.naufaldystd.schotersbacarita.domain.repository

import com.naufaldystd.schotersbacarita.domain.model.Article
import com.naufaldystd.schotersbacarita.util.Resource
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
	suspend fun getArticles(
		fetchFromRemote: Boolean,
		query: String
	): Flow<Resource<List<Article>>>
}