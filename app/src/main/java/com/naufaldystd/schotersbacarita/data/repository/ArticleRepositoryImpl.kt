package com.naufaldystd.schotersbacarita.data.repository

import com.naufaldystd.schotersbacarita.data.local.NewsDatabase
import com.naufaldystd.schotersbacarita.data.remote.NewsApi
import com.naufaldystd.schotersbacarita.domain.model.Article
import com.naufaldystd.schotersbacarita.domain.repository.ArticleRepository
import com.naufaldystd.schotersbacarita.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepositoryImpl @Inject constructor(
	private val api: NewsApi,
	private val db: NewsDatabase,
): ArticleRepository {
	override suspend fun getArticles(
		fetchFromRemote: Boolean,
		query: String
	): Flow<Resource<List<Article>>> {
		TODO("Not yet implemented")
	}
}