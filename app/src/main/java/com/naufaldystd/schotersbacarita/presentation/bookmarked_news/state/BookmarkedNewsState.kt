package com.naufaldystd.schotersbacarita.presentation.bookmarked_news.state

import com.naufaldystd.schotersbacarita.domain.model.Article

data class BookmarkedNewsState(
	val bookmarkedArticles: List<Article> = emptyList(),
	val error: String? = null
)
