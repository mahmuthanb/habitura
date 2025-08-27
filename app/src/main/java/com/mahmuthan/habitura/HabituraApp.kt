package com.mahmuthan.habitura

import android.app.Application
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.mahmuthan.habitura.presentation.navigation.NavGraph
import com.mahmuthan.habitura.ui.theme.HabituraTheme
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HabituraApp : Application()

@Composable
fun HabituraAppRoot() {
    HabituraTheme {
        val navController = rememberNavController()
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            // Just call NavGraph
            NavGraph(navController = navController)
        }
    }
}
