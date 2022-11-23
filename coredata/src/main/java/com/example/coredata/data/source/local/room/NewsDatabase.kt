package com.example.coredata.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coredata.data.source.local.NewsEntity

@Database(entities = [NewsEntity::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao

}