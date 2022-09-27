package com.naufaldystd.schotersbacarita.presentation.news_list.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.naufaldystd.schotersbacarita.domain.repository.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(private val repository: ArticleRepository) :
	ViewModel() {

	var state by mutableStateOf(NewsListState())
}