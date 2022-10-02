package com.naufaldystd.schotersbacarita.presentation.news_list.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
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
fun FeaturedNewsItem(
	article: Article,
	modifier: Modifier = Modifier
) {
	Card(
		modifier = modifier
			.width(280.dp)
			.height(180.dp),
		elevation = 12.dp
	) {
		Box() {
			Image(
				painter = rememberAsyncImagePainter(
					ImageRequest.Builder(LocalContext.current)
						.data(data = article.urlToImage)
						.allowHardware(false)
						.build()
				),
				contentDescription = article.title,
				modifier = Modifier
					.fillMaxHeight()
					.fillMaxWidth(),
				contentScale = ContentScale.FillBounds
			)
			Box(
				modifier = Modifier
					.fillMaxSize()
					.background(
						Brush.verticalGradient(
							colors = listOf(
								Color.Transparent,
								Color.Black
							),
							startY = 300f
						)
					)
			)
		}
		Column(
			modifier = Modifier
				.padding(8.dp),
			verticalArrangement = Arrangement.Bottom
		) {
			Text(
				text = article.title,
				fontWeight = FontWeight.Bold,
				fontSize = 14.sp,
				maxLines = 2,
				overflow = TextOverflow.Ellipsis,
				color = Color.White
			)
			Spacer(modifier = Modifier.height(8.dp))
			Text(
				text = article.publishedAt.formatDateTime(),
				fontSize = 14.sp,
				color = Color.LightGray,
				modifier = Modifier.padding(bottom = 8.dp)
			)
		}
	}
}