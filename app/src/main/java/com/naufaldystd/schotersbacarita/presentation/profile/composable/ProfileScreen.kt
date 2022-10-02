package com.naufaldystd.schotersbacarita.presentation.profile.composable


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.naufaldystd.schotersbacarita.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun ProfileScreen(
	navigator: DestinationsNavigator,
	modifier: Modifier = Modifier) {
	Column(
		modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
	) {
		TopAppBar(
			title = { Text(text = stringResource(R.string.headline_profile)) },
			backgroundColor = Color.White,
			navigationIcon = {
				IconButton(onClick = {
					navigator.navigateUp()
				}) {
					Icon(
						painter = painterResource(id = R.drawable.ic_back),
						contentDescription = stringResource(R.string.back_icon)
					)
				}
			}
		)
		Spacer(modifier = Modifier.height(32.dp))
		Image(
			painter = painterResource(id = R.drawable.mypic), contentDescription = stringResource(
				R.string.photo_profile
			), modifier = Modifier
				.clip(CircleShape)
				.size(180.dp)
		)
		Spacer(modifier = Modifier.height(16.dp))
		Text(text = stringResource(R.string.my_name), style = MaterialTheme.typography.h5)
		Spacer(modifier = Modifier.height(8.dp))
		Text(
			text = stringResource(R.string.github_username),
			style = MaterialTheme.typography.subtitle1,
			color = Color.DarkGray
		)
	}
}