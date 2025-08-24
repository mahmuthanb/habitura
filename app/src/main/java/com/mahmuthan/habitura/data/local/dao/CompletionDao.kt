package com.mahmuthan.habitura.data.local.dao

import androidx.room.*
import com.mahmuthan.habitura.data.local.entity.CompletionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CompletionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(completion: CompletionEntity): Long

    @Query("SELECT * FROM completions WHERE habitId = :habitId AND dateEpochDay = :dateEpochDay LIMIT 1")
    suspend fun get(habitId: Long, dateEpochDay: Long): CompletionEntity?

    @Query("DELETE FROM completions WHERE habitId = :habitId AND dateEpochDay = :dateEpochDay")
    suspend fun delete(habitId: Long, dateEpochDay: Long)

    @Query("SELECT * FROM completions WHERE habitId = :habitId ORDER BY dateEpochDay DESC")
    fun observeForHabit(habitId: Long): Flow<List<CompletionEntity>>

    @Query("SELECT * FROM completions WHERE dateEpochDay = :dateEpochDay")
    fun observeForDate(dateEpochDay: Long): Flow<List<CompletionEntity>>
}
