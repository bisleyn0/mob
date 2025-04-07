package pe.edu.navigationjpc.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import pe.edu.navigationjpc.ui.presentation.screens.CalculatorScreen
import pe.edu.navigationjpc.ui.presentation.screens.HomeScreen
import pe.edu.navigationjpc.ui.presentation.screens.ProfileScreen
import pe.edu.navigationjpc.ui.presentation.screens.SettingsScreen

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen() }
        composable("profile") { ProfileScreen() }
        composable("settings") { SettingsScreen() }
        composable("calc") { CalculatorScreen() }

    }
}
