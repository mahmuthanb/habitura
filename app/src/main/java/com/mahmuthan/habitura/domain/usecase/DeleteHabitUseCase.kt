package com.mahmuthan.habitura.domain.usecase

import com.mahmuthan.habitura.domain.model.Habit
import com.mahmuthan.habitura.domain.repo.HabitRepository

class DeleteHabitUseCase(
    private val repository: HabitRepository
) {
    suspend operator fun invoke(habit: Habit) = repository.deleteHabit(habit)
}
