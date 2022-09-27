package com.naufaldystd.schotersbacarita.presentation.news_list.state

import com.naufaldystd.schotersbacarita.domain.model.Article

data class NewsListState(
	val articles: List<Article> = emptyList(),
	val isLoading: Boolean = false,
	val isRefreshing: Boolean = false,
	val searchQuery: String = ""
)
