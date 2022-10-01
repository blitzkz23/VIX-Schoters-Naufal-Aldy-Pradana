package com.naufaldystd.schotersbacarita.presentation.news_list.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naufaldystd.schotersbacarita.domain.repository.ArticleRepository
import com.naufaldystd.schotersbacarita.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(private val repository: ArticleRepository) :
	ViewModel() {

	var state by mutableStateOf(NewsListState())
	private var searchJob: Job? = null

	init {
		getArticles()
	}

	/**
	 * When there's event/triggered
	 *
	 * @param event
	 */
	fun onEvent(event: NewsListEvent) {
		when (event) {
			is NewsListEvent.Refresh -> {
				getArticles(fetchFromRemote = true)
			}
			is NewsListEvent.OnSearchQueryChange -> {
				state = state.copy(searchQuery = event.query)
				searchJob?.cancel()
				searchJob = viewModelScope.launch {
					delay(500L)
					getArticles()
				}
			}
		}
	}

	/**
	 * Get articles data
	 *
	 * @param query
	 * @param fetchFromRemote
	 */
	private fun getArticles(
		query: String = state.searchQuery.lowercase(),
		fetchFromRemote: Boolean = false
	) {
		viewModelScope.launch {
			repository
				.getArticles(fetchFromRemote, query)
				.collect { result ->
					when (result) {
						is Resource.Success -> {
							result.data?.let { articles ->
								state = state.copy(
									articles = articles
								)
							}
						}
						is Resource.Error -> Unit
						is Resource.Loading -> {
							state = state.copy(
								isLoading = result.isLoading
							)
						}
					}
				}
		}
	}
}