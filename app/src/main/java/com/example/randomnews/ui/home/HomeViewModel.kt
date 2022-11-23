package com.example.randomnews.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.coredata.domain.usecase.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(newsUseCase: NewsUseCase):ViewModel() {
    val news = newsUseCase.getAllNews().asLiveData()
}