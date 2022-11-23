package com.example.randomnews.di

import com.example.coredata.data.source.NewsRepository
import com.example.coredata.domain.usecase.NewsInteractor
import com.example.coredata.domain.usecase.NewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNewsUseCase(newsRepository: NewsRepository): NewsUseCase=NewsInteractor(newsRepository)
}