package com.example.coredata.Util

import com.example.coredata.data.source.local.NewsEntity
import com.example.coredata.data.source.remote.NewsResponse
import com.example.coredata.domain.News

object DataMapper {
    fun mapResponsesToEntities(input: List<NewsResponse>): List<NewsEntity> {
        val newsList = ArrayList<NewsEntity>()
        input.map {
            val news = NewsEntity(
                newsId = it.newsId,
                author = it.author,
                content = it.content,
                date = it.date,
                title = it.title,
                imgUrl = it.imgUrl,
                isFavorite = false
            )
            newsList.add(news)
        }
        return newsList
    }

    fun mapEntitiesToDomain(input: List<NewsEntity>): List<News> =
        input.map {
            News(
                newsId = it.newsId,
                author = it.author,
                content = it.content,
                date = it.date,
                title = it.title,
                imgUrl = it.imgUrl,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: News) = NewsEntity(
        newsId = input.newsId,
        author = input.author,
        content = input.content,
        date = input.date,
        title = input.title,
        imgUrl = input.imgUrl,
        isFavorite = input.isFavorite
    )
}