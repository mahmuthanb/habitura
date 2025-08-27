// AddHabitScreen.kt
package com.mahmuthan.habitura.presentation.addhabit

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AddHabitScreen(
    onBack: () -> Unit,
    viewModel: AddHabitViewModel = hiltViewModel()
) {
    var habitTitle by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Add New Habit", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(
            value = habitTitle,
            onValueChange = { habitTitle = it },
            label = { Text("Habit title") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if (habitTitle.isNotBlank()) {
                    viewModel.addHabit(habitTitle)
                    //onHabitAdded()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Habit")
        }
    }
}
