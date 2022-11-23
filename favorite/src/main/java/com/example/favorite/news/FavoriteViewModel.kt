package com.example.favorite.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.coredata.domain.usecase.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(newsUseCase: NewsUseCase):ViewModel() {
    val favNews=newsUseCase.getFavoriteNews().asLiveData()
}