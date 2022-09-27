package com.naufaldystd.schotersbacarita.presentation.news_list.state

sealed class NewsListEvent {
	object Refresh : NewsListEvent()
	data class OnSearchQueryChange(val query: String) : NewsListEvent()
}
