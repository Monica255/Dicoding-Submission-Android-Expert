package com.example.coredata.data.source.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "news")
class NewsEntity (
    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "newsId")
    var newsId:String,

    @ColumnInfo(name = "date")
    var date:String,

    @ColumnInfo(name = "author")
    var author:String,

    @ColumnInfo(name = "newsTitle")
    var title:String,

    @ColumnInfo(name = "newsContent")
    var content:String,

    @ColumnInfo(name = "newsImgUrl")
    var imgUrl:String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite:Boolean
    )