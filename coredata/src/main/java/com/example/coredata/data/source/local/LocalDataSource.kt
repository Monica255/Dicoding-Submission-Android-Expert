package com.example.coredata.data.source.local

import com.example.coredata.data.source.local.room.NewsDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val newsDao: NewsDao){
    fun getAllNews(): Flow<List<NewsEntity>> = newsDao.getAllNews()

    fun getFavoriteTourism(): Flow<List<NewsEntity>> = newsDao.getFavoriteNews()

    suspend fun insertTourism(newsList: List<NewsEntity>) = newsDao.insertNews(newsList)

    fun setFavoriteTourism(tourism: NewsEntity, newState: Boolean) {
        tourism.isFavorite = newState
        newsDao.updateFavoriteNews(tourism)
    }

}