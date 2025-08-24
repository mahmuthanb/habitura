package com.mahmuthan.habitura.di

import android.content.Context
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
    fun provideDatabase(app: Context): HabituraDatabase {
        return Room.databaseBuilder(
            app,
            HabituraDatabase::class.java,
            "habit_db"
        ).build()
    }

    @Provides
    fun provideHabitDao(db: HabituraDatabase) = db.habitDao()

    @Provides
    @Singleton
    fun provideHabitRepository(dao: com.mahmuthan.habitura.data.local.dao.HabitDao): HabitRepository {
        return HabitRepositoryImpl(dao)
    }

    @Provides
    fun provideUseCases(repository: HabitRepository): HabitUseCases {
        return HabitUseCases(
            getHabits = GetHabitsUseCase(repository),
            getHabitById = GetHabitByIdUseCase(repository),
            insertHabit = InsertHabitUseCase(repository),
            deleteHabit = DeleteHabitUseCase(repository)
        )
    }
}

data class HabitUseCases(
    val getHabits: GetHabitsUseCase,
    val getHabitById: GetHabitByIdUseCase,
    val insertHabit: InsertHabitUseCase,
    val deleteHabit: DeleteHabitUseCase
)
