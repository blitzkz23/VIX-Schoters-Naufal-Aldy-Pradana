package com.naufaldystd.schotersbacarita.presentation.news_detail.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naufaldystd.schotersbacarita.domain.model.Article
import com.naufaldystd.schotersbacarita.domain.repository.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel @Inject constructor(
	private val savedStateHandle: SavedStateHandle
) : ViewModel() {
	var state by mutableStateOf(NewsDetailState())

	init {
		viewModelScope.launch {
			val article = savedStateHandle.get<Article>("article") ?: return@launch
			state = state.copy(
				article = article
			)
		}
	}
}