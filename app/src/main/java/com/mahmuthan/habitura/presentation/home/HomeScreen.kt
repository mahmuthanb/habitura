package com.mahmuthan.habitura.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mahmuthan.habitura.domain.model.Habit

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val habitList = viewModel.habits.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Habitura") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* TODO: Navigate to AddHabitScreen */ }) {
                Text("+")
            }
        }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(habitList) { habit ->
                HabitItem(habit = habit, onDelete = { viewModel.removeHabit(it) })
            }
        }
    }
}

@Composable
fun HabitItem(habit: Habit, onDelete: (Habit) -> Unit) {
    Card(
        elevation = 4.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = habit.title, style = MaterialTheme.typography.h6)
                habit.description?.let { Text(text = it, style = MaterialTheme.typography.body2) }
            }
            IconButton(onClick = { onDelete(habit) }) {
                Icon(Icons.Default.Delete, contentDescription = "Delete Habit")
            }
        }
    }
}
