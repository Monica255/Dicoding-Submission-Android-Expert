package com.example.coredata.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class News(
    var newsId: String,
    var date:String,
    var author: String,
    var title: String,
    var content: String,
    var imgUrl: String,
    var isFavorite:Boolean
):Parcelable