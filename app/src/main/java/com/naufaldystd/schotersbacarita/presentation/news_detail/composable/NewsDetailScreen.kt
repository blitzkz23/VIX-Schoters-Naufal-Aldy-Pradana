package com.naufaldystd.schotersbacarita.presentation.news_detail.composable

import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import com.naufaldystd.schotersbacarita.R
import com.naufaldystd.schotersbacarita.domain.model.Article
import com.naufaldystd.schotersbacarita.presentation.news_detail.state.NewsDetailViewModel
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.launch

@Composable
@Destination
fun NewsDetailScreen(
	article: Article,
	viewModel: NewsDetailViewModel = hiltViewModel()
) {
	val state = viewModel.state
	val context = LocalContext.current
	val coroutineScope = rememberCoroutineScope()

	Log.d("State of news", state.article.toString())
	Column(modifier = Modifier.fillMaxSize()) {
		TopAppBar(
			title = { Text(text = context.getString(R.string.app_title)) },
			backgroundColor = Color.White,
			actions = {
				if (state.article?.isFavorite == true) {
					IconButton(onClick = {
						var bookmarkStatus = state.article.isFavorite
						var newBookmarkStatus = !bookmarkStatus!!

						viewModel.setBookmarkNews(state.article, newBookmarkStatus)
					}) {
						Icon(
							painter = painterResource(id = R.drawable.ic_bookmark),
							contentDescription = stringResource(R.string.bookmark),
						)
					}
				} else {
					IconButton(onClick = {
						var bookmarkStatus = state.article?.isFavorite
						var newBookmarkStatus = !bookmarkStatus!!
						state.article?.isFavorite = false
						state.article?.let { viewModel.setBookmarkNews(it, newBookmarkStatus) }
					}) {
						Icon(
							painter = painterResource(id = R.drawable.ic_bookmark_border),
							contentDescription = stringResource(R.string.bookmark),
						)
					}
				}
			}
		)
		AndroidView(factory = {
			WebView(context).apply {
				webViewClient = WebViewClient()

				loadUrl(article.url)
			}
		})
	}
}