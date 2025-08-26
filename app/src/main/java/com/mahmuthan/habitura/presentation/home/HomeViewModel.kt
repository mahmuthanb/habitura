package com.mahmuthan.habitura.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahmuthan.habitura.domain.model.Habit
import com.mahmuthan.habitura.domain.usecase.DeleteHabitUseCase
import com.mahmuthan.habitura.domain.usecase.GetHabitsUseCase
import com.mahmuthan.habitura.domain.usecase.InsertHabitUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(
    getHabitsUseCase: GetHabitsUseCase,
    private val insertHabitUseCase: InsertHabitUseCase,
    private val deleteHabitUseCase: DeleteHabitUseCase
) : ViewModel() {

    // StateFlow ile UI’ya stream
    val habits: StateFlow<List<Habit>> = getHabitsUseCase()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun addHabit(habit: Habit) {
        viewModelScope.launch {
            insertHabitUseCase(habit)
        }
    }

    fun removeHabit(habit: Habit) {
        viewModelScope.launch {
            deleteHabitUseCase(habit)
        }
    }
}
