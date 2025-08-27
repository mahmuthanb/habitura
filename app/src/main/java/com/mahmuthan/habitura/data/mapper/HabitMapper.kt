package com.mahmuthan.habitura.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.mahmuthan.habitura.data.local.entity.HabitEntity
import com.mahmuthan.habitura.domain.model.Habit
import java.time.DayOfWeek
import java.time.LocalDate

// ---- Bit mask <-> Set<DayOfWeek> ----
// Maske bitleri: 0=MONDAY ... 6=SUNDAY
private fun Int.toDayOfWeekSet(): Set<DayOfWeek> {
    val out = mutableSetOf<DayOfWeek>()
    DayOfWeek.values().forEach { day ->
        val bit = 1 shl day.ordinal
        if ((this and bit) != 0) out += day
    }
    return out
}

private fun Set<DayOfWeek>.toMask(): Int {
    var mask = 0
    for (day in this) mask = mask or (1 shl day.ordinal)
    return mask
}

// ---- Entity -> Domain ----
fun HabitEntity.toDomain(): Habit = Habit(
    id = id,
    title = title,
    description = description,
    colorArgb = colorArgb,
    recurrence = recurrenceMask.toDayOfWeekSet(),
    createdAt = LocalDate.ofEpochDay(createdAtEpochDay),
    isArchived = isArchived
)

// ---- Domain -> Entity ----
fun Habit.toEntity(): HabitEntity = HabitEntity(
    id = id,
    title = title,
    description = description,
    colorArgb = colorArgb,
    recurrenceMask = recurrence.toMask(),
    createdAtEpochDay = createdAt.toEpochDay(),
    isArchived = isArchived
)
