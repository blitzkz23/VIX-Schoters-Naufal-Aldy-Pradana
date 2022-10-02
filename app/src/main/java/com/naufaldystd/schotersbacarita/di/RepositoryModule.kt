package com.naufaldystd.schotersbacarita.di

import com.naufaldystd.schotersbacarita.data.repository.ArticleRepositoryImpl
import com.naufaldystd.schotersbacarita.domain.repository.ArticleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

	@Binds
	@Singleton
	abstract fun bindNewsRepository(articleRepositoryImpl: ArticleRepositoryImpl): ArticleRepository
}