package com.naufaldystd.schotersbacarita.presentation.bookmarked_news.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naufaldystd.schotersbacarita.domain.repository.ArticleRepository
import com.naufaldystd.schotersbacarita.presentation.news_list.state.NewsListEvent
import com.naufaldystd.schotersbacarita.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarkedNewsViewModel @Inject constructor(private val repository: ArticleRepository) :
	ViewModel() {

	var state by mutableStateOf(BookmarkedNewsState())

	init {
//		getArticles()
	}

}