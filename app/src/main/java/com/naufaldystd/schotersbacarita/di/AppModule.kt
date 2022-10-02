package com.naufaldystd.schotersbacarita.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.naufaldystd.schotersbacarita.data.local.NewsDatabase
import com.naufaldystd.schotersbacarita.data.remote.NewsApi
import com.naufaldystd.schotersbacarita.data.remote.NewsApi.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

	@Provides
	@Singleton
	fun provideNewsApi(): NewsApi {
		return Retrofit.Builder()
			.baseUrl(BASE_URL)
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create()
	}

	@Provides
	@Singleton
	fun provideNewsDatabase(app: Application): NewsDatabase {
		return Room.databaseBuilder(app, NewsDatabase::class.java, "newsdb.db").build()
	}

	@Provides
	@Singleton
	fun provideContext(app: Application): Context = app.applicationContext
}