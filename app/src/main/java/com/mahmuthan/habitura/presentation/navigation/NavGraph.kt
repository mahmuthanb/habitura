package com.mahmuthan.habitura.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mahmuthan.habitura.presentation.addhabit.AddHabitScreen
import com.mahmuthan.habitura.presentation.detail.HabitDetailScreen
import com.mahmuthan.habitura.presentation.home.HomeScreen
import com.mahmuthan.habitura.presentation.home.HomeViewModel

// presentation/navigation/NavGraph.kt
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            val homeViewModel: HomeViewModel = hiltViewModel()  // inject via Hilt
            HomeScreen(viewModel = homeViewModel, navController = navController)
        }
        composable(Screen.AddHabit.route) {
            AddHabitScreen(
                onBack = { navController.popBackStack() }
            )
        }
        composable(
            Screen.HabitDetails.route,
            arguments = listOf(navArgument("habitId") { type = NavType.IntType })
        ) { backStackEntry ->
            val habitId = backStackEntry.arguments?.getInt("habitId") ?: -1
        }
    }
}
