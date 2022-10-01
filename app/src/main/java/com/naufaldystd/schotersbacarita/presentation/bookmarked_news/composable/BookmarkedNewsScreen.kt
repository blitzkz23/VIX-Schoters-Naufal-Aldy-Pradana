package com.naufaldystd.schotersbacarita.presentation.bookmarked_news.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.naufaldystd.schotersbacarita.R
import com.naufaldystd.schotersbacarita.presentation.bookmarked_news.state.BookmarkedNewsViewModel
import com.naufaldystd.schotersbacarita.presentation.destinations.BookmarkedNewsScreenDestination
import com.naufaldystd.schotersbacarita.presentation.news_list.composable.NewsItem
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun BookmarkedNewsScreen(
	navigator: DestinationsNavigator,
	viewModel: BookmarkedNewsViewModel = hiltViewModel()
) {
	val state = viewModel.state

	Column(modifier = Modifier.fillMaxSize()) {
		TopAppBar(
			title = { Text(text = "Berita Tersimpan") },
			backgroundColor = Color.White,
		)
		LazyColumn() {
			items(state.bookmarkedArticles.size) { index ->
				val article = state.bookmarkedArticles[index]
				NewsItem(
					article = article, modifier = Modifier
						.fillMaxWidth()
						.padding(16.dp)
				)
			}
		}
	}

}