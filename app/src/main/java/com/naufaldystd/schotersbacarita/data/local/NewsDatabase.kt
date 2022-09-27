package com.naufaldystd.schotersbacarita.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.naufaldystd.schotersbacarita.data.local.entity.ArticleEntity

@Database(
	entities = [ArticleEntity::class],
	version = 1,
	exportSchema = false
)
abstract class NewsDatabase : RoomDatabase() {
	abstract val dao: NewsDao
}