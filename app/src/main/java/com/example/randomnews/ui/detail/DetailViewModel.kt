package com.example.randomnews.ui.detail

import androidx.lifecycle.ViewModel
import com.example.coredata.domain.News
import com.example.coredata.domain.usecase.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val tourismUseCase: NewsUseCase) :ViewModel() {
    fun setFavoriteTourism(news: News, newStatus:Boolean) =
        tourismUseCase.setFavoriteNews(news, newStatus)
}