package com.mahmuthan.habitura.data.local.dao

import androidx.room.*
import com.mahmuthan.habitura.data.local.entity.HabitEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {
    @Insert suspend fun insert(habit: HabitEntity): Long
    @Update suspend fun update(habit: HabitEntity)
    @Delete suspend fun delete(habit: HabitEntity)

    @Query("SELECT * FROM habits WHERE isArchived = 0 ORDER BY id DESC")
    fun observeActiveHabits(): Flow<List<HabitEntity>>

    @Query("SELECT * FROM habits WHERE id = :id LIMIT 1")
    suspend fun getById(id: Int): HabitEntity?

    @Query("SELECT * FROM habits")
    suspend fun getAllOnce(): List<HabitEntity>
}
