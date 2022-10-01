package com.naufaldystd.schotersbacarita.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Format date time by parsing given string and format it to desired pattern.
 *
 * @return
 */
fun String.formatDateTime(): String {
	val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
	val formatter = SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault())
	return formatter.format(parser.parse(this)!!)
}