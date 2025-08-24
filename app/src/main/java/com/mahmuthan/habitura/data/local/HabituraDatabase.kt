package com.mahmuthan.habitura.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mahmuthan.habitura.data.local.dao.CompletionDao
import com.mahmuthan.habitura.data.local.dao.HabitDao
import com.mahmuthan.habitura.data.local.entity.CompletionEntity
import com.mahmuthan.habitura.data.local.entity.HabitEntity

@Database(
    entities = [HabitEntity::class, CompletionEntity::class],
    version = 1,
    exportSchema = true
)
abstract class HabituraDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao
    abstract fun completionDao(): CompletionDao
}
