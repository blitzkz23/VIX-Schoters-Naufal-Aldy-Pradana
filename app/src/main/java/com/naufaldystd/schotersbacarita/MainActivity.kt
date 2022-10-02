package com.naufaldystd.schotersbacarita

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.naufaldystd.schotersbacarita.presentation.NavGraphs
import com.naufaldystd.schotersbacarita.ui.theme.BackgroundWhite
import com.naufaldystd.schotersbacarita.ui.theme.SchotersBacaritaTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			SchotersBacaritaTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = BackgroundWhite
				) {
					DestinationsNavHost(navGraph = NavGraphs.root)
				}
			}
		}
	}
}
