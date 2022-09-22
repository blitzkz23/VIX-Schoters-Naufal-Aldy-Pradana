package com.naufaldystd.schotersbacarita.data.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.naufaldystd.schotersbacarita.data.local.entity.ArticleEntity
import androidx.room.Query

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
}