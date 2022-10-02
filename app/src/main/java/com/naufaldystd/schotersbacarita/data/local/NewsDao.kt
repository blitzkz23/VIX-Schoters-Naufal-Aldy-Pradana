package com.naufaldystd.schotersbacarita.data.local

import androidx.room.*
import com.naufaldystd.schotersbacarita.data.local.entity.ArticleEntity

@Dao
interface NewsDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertArticles(
		articles: List<ArticleEntity>
	)

	@Query(
		"""
            SELECT * 
            FROM articleEntity
            WHERE LOWER(title) LIKE '%' || LOWER(:query) || '%' OR
                UPPER(:query) 
        """
	)
	suspend fun searchArticle(query: String): List<ArticleEntity>

	@Query("DELETE FROM articleEntity")
	suspend fun clearArticleList()

	@Query("SELECT * FROM articleEntity WHERE isFavorite = 1")
	suspend fun getBookmarkedArticle(): List<ArticleEntity>

	@Update
	fun updateNewsData(article: ArticleEntity)

	@Query("SELECT * FROM articleEntity WHERE id =:id")
	suspend fun getArticleById(id: Int): ArticleEntity
}