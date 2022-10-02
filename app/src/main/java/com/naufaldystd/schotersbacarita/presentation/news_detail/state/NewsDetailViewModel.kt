package com.naufaldystd.schotersbacarita.presentation.news_detail.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naufaldystd.schotersbacarita.domain.model.Article
import com.naufaldystd.schotersbacarita.domain.repository.ArticleRepository
import com.naufaldystd.schotersbacarita.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel @Inject constructor(
	private val savedStateHandle: SavedStateHandle,
	private val repository: ArticleRepository
) : ViewModel() {
	var state by mutableStateOf(NewsDetailState())

	init {
		viewModelScope.launch {
			val articleArg = savedStateHandle.get<Article>("article") ?: return@launch
//			when (val result = repository.getArticleById(articleArg.id)) {
//				is Resource.Success -> {
//					state = state.copy(
//						article = result.data
//					)
//				}
//				is Resource.Error -> Unit
//				else -> Unit
//			}
			state = state.copy(
				article = articleArg
			)
		}
	}

	fun setBookmarkNews(article: Article, newState: Boolean) =
		repository.setBookmarkNews(article, newState)
}