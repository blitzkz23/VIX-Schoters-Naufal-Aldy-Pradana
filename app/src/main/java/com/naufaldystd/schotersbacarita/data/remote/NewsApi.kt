package com.naufaldystd.schotersbacarita.data.remote

import com.naufaldystd.schotersbacarita.data.remote.response.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

	@GET("top-headlines")
	suspend fun getNews(
		@Query("country") country: String = "id",
		@Query("apiKey") apiKey: String = API_KEY
	): NewsResponse

	companion object {
		const val API_KEY = "47a9e40ff58c41108c94e096ae30e72e"
		const val BASE_URL = "https://newsapi.org/v2/"
	}
}