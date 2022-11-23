package com.example.coredata.domain.usecase

import com.example.coredata.domain.News
import com.example.coredata.domain.repository.INewsRepository
import javax.inject.Inject

class NewsInteractor @Inject constructor(private val newsRepository:INewsRepository):NewsUseCase {
    override fun getAllNews() = newsRepository.getAllNews()

    override fun getFavoriteNews() = newsRepository.getFavoriteNews()

    override fun setFavoriteNews(news: News, state: Boolean) = newsRepository.setFavoriteNews(news, state)
}