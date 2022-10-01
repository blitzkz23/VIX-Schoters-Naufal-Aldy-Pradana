package com.naufaldystd.schotersbacarita.presentation.news_list.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Colors
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.naufaldystd.schotersbacarita.presentation.news_list.state.NewsListEvent
import com.naufaldystd.schotersbacarita.presentation.news_list.state.NewsListViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Composable
@Destination(start = true)
fun NewsListScreen(
	navigator: DestinationsNavigator,
	viewModel: NewsListViewModel = hiltViewModel()
) {
	val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = viewModel.state.isRefreshing)
	val state = viewModel.state

	Column(
		modifier = Modifier
			.fillMaxSize()
	) {
		OutlinedTextField(
			value = state.searchQuery, onValueChange = {
				viewModel.onEvent(NewsListEvent.OnSearchQueryChange(it))
			}, modifier = Modifier
				.fillMaxWidth()
				.padding(16.dp),
			placeholder = {
				Text(text = "Cari berita di sini...")
			}, maxLines = 1, singleLine = true
		)
		SwipeRefresh(state = swipeRefreshState, onRefresh = {
			viewModel.onEvent(NewsListEvent.Refresh)
		}) {
			LazyColumn(modifier = Modifier.fillMaxSize()) {
				items(state.articles.size) { index ->
					val article = state.articles[index]
					NewsItem(article = article, modifier = Modifier
						.fillMaxWidth()
						.padding(16.dp))
					if(index < state.articles.size) {
						Divider(modifier = Modifier.padding(
							horizontal = 16.dp
						))
					}
				}
			}
		}
	}
}