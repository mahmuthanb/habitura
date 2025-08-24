package com.mahmuthan.habitura.data.local.entity

import androidx.room.*

@Entity(
    tableName = "completions",
    indices = [Index(value = ["habitId", "dateEpochDay"], unique = true)],
    foreignKeys = [
        ForeignKey(
            entity = HabitEntity::class,
            parentColumns = ["id"],
            childColumns = ["habitId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class CompletionEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val habitId: Long,
    val dateEpochDay: Long,
    val isCompleted: Boolean = true
)
