package com.mahmuthan.habitura.data.repo

import android.os.Build
import androidx.annotation.RequiresApi
import com.mahmuthan.habitura.data.local.dao.HabitDao
import com.mahmuthan.habitura.data.local.entity.HabitEntity
import com.mahmuthan.habitura.data.mapper.toDomain
import com.mahmuthan.habitura.data.mapper.toEntity
import com.mahmuthan.habitura.domain.model.Habit
import com.mahmuthan.habitura.domain.repo.HabitRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
@RequiresApi(Build.VERSION_CODES.O)
class HabitRepositoryImpl(
    private val dao: HabitDao
) : HabitRepository {

    override fun getHabits(): Flow<List<Habit>> {
        return dao.observeActiveHabits().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun getHabitById(id: Int): Habit? {
        return dao.getById(id)?.toDomain()
    }

    override suspend fun insertHabit(habit: Habit) {
        if (habit.id == 0) {
            dao.insert(habit.toEntity())
        } else {
            dao.update(habit.toEntity())
        }
    }

    override suspend fun deleteHabit(habit: Habit) {
        dao.delete(habit.toEntity())
    }
}
