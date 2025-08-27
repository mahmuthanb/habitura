package com.mahmuthan.habitura.presentation.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object AddHabit : Screen("add_habit")
    object HabitDetails : Screen("habit_details/{habitId}") {
        fun createRoute(habitId: Int) = "habit_details/$habitId"
    }
}