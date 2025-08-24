package com.mahmuthan.habitura.data.repo

import com.mahmuthan.habitura.data.local.dao.HabitDao
import com.mahmuthan.habitura.data.local.entity.HabitEntity
import com.mahmuthan.habitura.domain.model.Habit
import com.mahmuthan.habitura.domain.repo.HabitRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HabitRepositoryImpl(
    private val dao: HabitDao
) : HabitRepository {

    override fun getHabits(): Flow<List<Habit>> {
        return dao.getHabits().map { list -> list.map { it.toDomain() } }
    }

    override suspend fun getHabitById(id: Int): Habit? {
        return dao.getHabitById(id)?.toDomain()
    }

    override suspend fun insertHabit(habit: Habit) {
        dao.insertHabit(HabitEntity.fromDomain(habit))
    }

    override suspend fun deleteHabit(habit: Habit) {
        dao.deleteHabit(HabitEntity.fromDomain(habit))
    }
}
