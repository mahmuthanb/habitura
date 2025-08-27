package com.mahmuthan.habitura.di

import com.mahmuthan.habitura.domain.repo.HabitRepository
import com.mahmuthan.habitura.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideHabitUseCases(repository: HabitRepository): HabitUseCases {
        return HabitUseCases(
            insertHabit = InsertHabitUseCase(repository),
            getHabits = GetHabitsUseCase(repository),
            getHabitById = GetHabitByIdUseCase(repository),
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
