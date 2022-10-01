package com.naufaldystd.schotersbacarita.presentation.news_list.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.naufaldystd.schotersbacarita.domain.model.Article

@Composable
fun NewsItem(
	article: Article,
	modifier: Modifier = Modifier
) {
	Row(
		modifier = modifier,
		verticalAlignment = Alignment.CenterVertically
	) {
		Text(text = article.title)
	}
}