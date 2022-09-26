package com.naufaldystd.schotersbacarita.data.repository

import android.content.Context
import com.naufaldystd.schotersbacarita.R
import com.naufaldystd.schotersbacarita.data.local.NewsDatabase
import com.naufaldystd.schotersbacarita.data.mapper.toArticle
import com.naufaldystd.schotersbacarita.data.mapper.toArticleEntities
import com.naufaldystd.schotersbacarita.data.remote.NewsApi
import com.naufaldystd.schotersbacarita.domain.model.Article
import com.naufaldystd.schotersbacarita.domain.repository.ArticleRepository
import com.naufaldystd.schotersbacarita.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepositoryImpl @Inject constructor(
	private val api: NewsApi,
	private val db: NewsDatabase,
	private val context: Context
) : ArticleRepository {
	private val dao = db.dao

	/**
	 * Get articles implementation for either network or local
	 *
	 * @param fetchFromRemote
	 * @param query
	 * @return
	 */
	override suspend fun getArticles(
		fetchFromRemote: Boolean,
		query: String
	): Flow<Resource<List<Article>>> {
		return flow {
			// If query exist, fetch from local news based on query
			emit(Resource.Loading(true))
			val localNews = dao.searchArticle(query)
			emit(Resource.Success(
				data = localNews.map { it.toArticle() }
			))

			// Check if should load from cache
			val isDbEmpty = localNews.isEmpty() && query.isBlank()
			val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote
			if (shouldJustLoadFromCache) {
				emit(Resource.Loading(false))
				return@flow
			}

			// If get data from remote
			val remoteNews = try {
				val response = api.getNews()
				response
			} catch (e: IOException) {
				e.printStackTrace()
				emit(Resource.Error(context.getString(R.string.error_io)))
				null
			} catch (e: HttpException) {
				e.printStackTrace()
				emit(Resource.Error(context.getString(R.string.error_http)))
				null
			}

			remoteNews?.let { news ->
				dao.clearArticleList()
				dao.insertArticles(
					news.articles.map { articleItem ->
						articleItem.toArticleEntities()
					}
				)
				emit(Resource.Loading(false))
				emit(Resource.Success(
					data = dao
						.searchArticle("")
						.map { it.toArticle() }
				))
			}
		}
	}
}