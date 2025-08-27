package com.mahmuthan.habitura.di

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Room
import com.mahmuthan.habitura.data.local.HabituraDatabase
import com.mahmuthan.habitura.data.repo.HabitRepositoryImpl
import com.mahmuthan.habitura.domain.repo.HabitRepository
import com.mahmuthan.habitura.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHabitRepository(dao: com.mahmuthan.habitura.data.local.dao.HabitDao): HabitRepository {
        return HabitRepositoryImpl(dao)
    }

}