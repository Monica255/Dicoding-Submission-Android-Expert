package com.example.coredata.domain.usecase

import com.example.coredata.data.source.Resource
import com.example.coredata.domain.News
import kotlinx.coroutines.flow.Flow

interface NewsUseCase {
    fun getAllNews(): Flow<Resource<List<News>>>
    fun getFavoriteNews(): Flow<List<News>>
    fun setFavoriteNews(news: News, state: Boolean)
}