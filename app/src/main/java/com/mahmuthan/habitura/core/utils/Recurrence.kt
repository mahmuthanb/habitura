package com.mahmuthan.habitura.core.utils

enum class WeekDay(val bit: Int) {
    MON(1 shl 0), TUE(1 shl 1), WED(1 shl 2),
    THU(1 shl 3), FRI(1 shl 4), SAT(1 shl 5), SUN(1 shl 6)
}

object Recurrence {
    fun allDaysMask(): Int = WeekDay.values().fold(0) { acc, d -> acc or d.bit }
    fun daysToMask(days: Set<WeekDay>): Int = days.fold(0) { acc, d -> acc or d.bit }
    fun includes(mask: Int, day: WeekDay): Boolean = (mask and day.bit) != 0
}
