// AddHabitViewModel.kt
package com.mahmuthan.habitura.presentation.addhabit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahmuthan.habitura.di.HabitUseCases
import com.mahmuthan.habitura.domain.model.Habit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.DayOfWeek
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class AddHabitViewModel @Inject constructor(
    private val useCases: HabitUseCases
) : ViewModel() {

    fun addHabit(title: String) {
        viewModelScope.launch {
            val habit = Habit(
                title = title,
                description = "description",
                recurrence = DayOfWeek.entries.toSet(),
                createdAt = LocalDate.now()
            )
            // Insert (InsertHabitUseCase has operator fun invoke(habit: Habit))
           useCases.insertHabit(habit)
        }
    }
}
