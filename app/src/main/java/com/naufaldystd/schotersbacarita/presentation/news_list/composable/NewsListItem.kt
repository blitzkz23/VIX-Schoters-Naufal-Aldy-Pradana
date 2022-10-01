package com.naufaldystd.schotersbacarita.presentation.news_list.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.naufaldystd.schotersbacarita.domain.model.Article
import com.naufaldystd.schotersbacarita.util.formatDateTime

@Composable
fun NewsItem(
	article: Article,
	modifier: Modifier = Modifier
) {
	Row(
		modifier = modifier
			.fillMaxWidth()
	) {
		Image(
			painter = rememberAsyncImagePainter(
				ImageRequest.Builder(LocalContext.current)
					.data(article.urlToImage)
					.crossfade(true)
					.build(),
			),
			contentDescription = article.title,
			modifier = Modifier
				.width(140.dp)
				.height(100.dp)
				.clip(RoundedCornerShape(percent = 30)),
			contentScale = ContentScale.Fit
		)
		Spacer(modifier = Modifier.width(8.dp))
		Column {
			Text(
				text = article.title,
				overflow = TextOverflow.Ellipsis,
				maxLines = 2,
				fontSize = 14.sp,
				fontWeight = FontWeight.Bold,
				modifier = Modifier.padding(top = 16.dp)
			)
			Spacer(modifier = Modifier.height(8.dp))
			Text(
				text = article.publishedAt.formatDateTime(),
				fontSize = 12.sp,
				color = Color.LightGray
			)
		}
	}
}