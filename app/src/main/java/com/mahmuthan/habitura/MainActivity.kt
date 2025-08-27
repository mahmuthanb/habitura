package com.mahmuthan.habitura

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.mahmuthan.habitura.presentation.navigation.NavGraph
import com.mahmuthan.habitura.ui.theme.HabituraTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HabituraAppRoot()
        }
    }
}

