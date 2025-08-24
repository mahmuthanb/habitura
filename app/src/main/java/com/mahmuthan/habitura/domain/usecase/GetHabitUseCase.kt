package com.mahmuthan.habitura.domain.usecase

import com.mahmuthan.habitura.domain.model.Habit
import com.mahmuthan.habitura.domain.repo.HabitRepository
import kotlinx.coroutines.flow.Flow

class GetHabitsUseCase(
    private val repository: HabitRepository
) {
    operator fun invoke(): Flow<List<Habit>> {
        return repository.getHabits()
    }
}
