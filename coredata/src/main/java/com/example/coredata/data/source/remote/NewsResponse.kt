package com.example.coredata.data.source.remote

import com.google.gson.annotations.SerializedName


class NewsResponse(
    @field:SerializedName("id")
    var newsId: String,
    @field:SerializedName("date")
    var date: String,
    @field:SerializedName("author")
    var author: String,
    @field:SerializedName("title")
    var title: String,
    @field:SerializedName("content")
    var content: String,
    @field:SerializedName("imageUrl")
    var imgUrl: String,
)