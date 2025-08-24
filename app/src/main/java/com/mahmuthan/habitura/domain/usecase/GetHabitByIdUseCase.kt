package com.mahmuthan.habitura.domain.usecase

import com.mahmuthan.habitura.domain.model.Habit
import com.mahmuthan.habitura.domain.repo.HabitRepository

class GetHabitByIdUseCase(
    private val repository: HabitRepository
) {
    suspend operator fun invoke(id: Int): Habit? = repository.getHabitById(id)
}