package com.naufaldystd.schotersbacarita.presentation.news_detail.composable

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import com.naufaldystd.schotersbacarita.R
import com.naufaldystd.schotersbacarita.domain.model.Article
import com.naufaldystd.schotersbacarita.presentation.news_detail.state.NewsDetailViewModel
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination
fun NewsDetailScreen(
	article: Article,
	viewModel: NewsDetailViewModel = hiltViewModel()
) {
	val state = viewModel.state
	val context = LocalContext.current

	Column(modifier = Modifier.fillMaxSize()) {
		TopAppBar(
			title = { Text(text = stringResource(R.string.app_title)) },
			backgroundColor = Color.White,
		)
		AndroidView(factory = {
			WebView(context).apply {
				webViewClient = WebViewClient()

				state.article?.let { it1 -> loadUrl(it1.url) }
			}
		})
	}
}