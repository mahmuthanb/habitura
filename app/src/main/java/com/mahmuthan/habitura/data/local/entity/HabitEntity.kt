package com.mahmuthan.habitura.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * recurrenceMask: 7 bitlik maske (Mon..Sun). Varsayılan: tüm günler açık.
 * createdAtEpochDay: epoch day (UTC) -> Long
 */
@Entity(tableName = "habits")
data class HabitEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String? = null,
    val colorArgb: Int = 0xFF4CAF50.toInt(), // varsayılan yeşil
    val recurrenceMask: Int,
    val createdAtEpochDay: Long,
    val isArchived: Boolean = false
)
