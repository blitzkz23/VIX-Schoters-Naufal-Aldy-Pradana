package com.naufaldystd.schotersbacarita.presentation.news_list.composable

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.naufaldystd.schotersbacarita.R
import com.naufaldystd.schotersbacarita.presentation.destinations.BookmarkedNewsScreenDestination
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

	if (state.error == null && state.searchQuery == "") {
		Column(
			modifier = Modifier
				.fillMaxSize()
		) {
			TopAppBar(
				title = { Text(text = "Schoters Bacarita") },
				backgroundColor = Color.White,
				actions = {
					IconButton(onClick = {

					}) {
						Icon(
							painter = painterResource(id = R.drawable.ic_person),
							contentDescription = "Profile"
						)
					}
					IconButton(onClick = {
						navigator.navigate(
							BookmarkedNewsScreenDestination()
						)
					}) {
						Icon(
							painter = painterResource(id = R.drawable.ic_bookmark),
							contentDescription = "Bookmark"
						)
					}
				}
			)
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
			Text(
				text = "Berita Panas",
				fontWeight = FontWeight.Bold,
				fontSize = 16.sp,
				modifier = Modifier.padding(start = 16.dp)
			)
			LazyRow(modifier = Modifier.fillMaxWidth()) {
				val items = state.featuredArticle
				Log.d("Item featured", items.toString())
				items(items.size) { index ->
					val featuredArticle = items[index]
					FeaturedNewsItem(
						article = featuredArticle,
						modifier = Modifier
							.fillMaxWidth()
							.padding(16.dp)
					)
				}
			}
			Text(
				text = "Berita Terkini", fontWeight = FontWeight.Bold, fontSize = 16.sp,
				modifier = Modifier.padding(start = 16.dp)
			)
			SwipeRefresh(state = swipeRefreshState, onRefresh = {
				viewModel.onEvent(NewsListEvent.Refresh)
			}) {
				LazyColumn(
					modifier = Modifier
						.fillMaxSize(),
					contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
				) {
					val items = state.articles.filter { !it.isFeatured }
					items(items.size) { index ->
						val article = items[index]
						NewsItem(
							article = article, modifier = Modifier
								.fillMaxWidth()
						)
					}
				}
			}
		}
	}

	// When state is loading or error
	Box(
		modifier = Modifier.fillMaxSize(),
		contentAlignment = Alignment.Center
	) {
		if (state.isLoading) {
			CircularProgressIndicator()
		} else if (state.error != null) {
			Text(
				text = state.error,
				color = MaterialTheme.colors.error
			)
		}
	}
}