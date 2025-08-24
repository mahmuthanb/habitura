package com.mahmuthan.habitura.di

import android.content.Context
import androidx.room.Room
import com.mahmuthan.habitura.data.local.HabituraDatabase
import com.mahmuthan.habitura.data.local.dao.CompletionDao
import com.mahmuthan.habitura.data.local.dao.HabitDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides @Singleton
    fun provideDatabase(@ApplicationContext context: Context): HabituraDatabase =
        Room.databaseBuilder(context, HabituraDatabase::class.java, "habitura.db")
            .fallbackToDestructiveMigration(false)
            .build()

    @Provides fun provideHabitDao(db: HabituraDatabase): HabitDao = db.habitDao()
    @Provides fun provideCompletionDao(db: HabituraDatabase): CompletionDao = db.completionDao()
}
