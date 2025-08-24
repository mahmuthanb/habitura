package com.mahmuthan.habitura.domain.model

import java.time.DayOfWeek
import java.util.UUID

/**
 * Domain model for a Habit.
 * Pure Kotlin data class, no Android dependencies.
 */
data class Habit(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val description: String? = null,
    val colorHex: String = "#2196F3", // Default Blue
    val recurrence: Set<DayOfWeek>, // Which days habit repeats
    val createdAt: Long = System.currentTimeMillis(),
    val isArchived: Boolean = false
)
