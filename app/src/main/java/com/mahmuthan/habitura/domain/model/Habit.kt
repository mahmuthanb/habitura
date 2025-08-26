package com.mahmuthan.habitura.domain.model

import java.time.DayOfWeek
import java.time.LocalDate
import java.util.UUID

/**
 * Domain model for a Habit.
 * Pure Kotlin data class, no Android dependencies.
 */
data class Habit(
    val id: Int = 0,                       // Room autoGenerate ile uyumlu
    val title: String,
    val description: String? = null,
    val colorArgb: Int = 0xFF4CAF50.toInt(),
    val recurrence: Set<DayOfWeek>,        // Domain tarafı: gün seti
    val createdAt: LocalDate,              // Domain tarafı: LocalDate
    val isArchived: Boolean = false
)
