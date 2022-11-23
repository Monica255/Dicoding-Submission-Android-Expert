package com.example.coredata.data.source.remote

import com.google.gson.annotations.SerializedName

class ListNewsResponse(
    @field:SerializedName("category")
    var category: String,
    @field:SerializedName("data")
    var data:List<NewsResponse>
)