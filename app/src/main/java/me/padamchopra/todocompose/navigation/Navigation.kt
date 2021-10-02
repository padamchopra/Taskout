package me.padamchopra.todocompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import me.padamchopra.todocompose.navigation.destinations.listComposable
import me.padamchopra.todocompose.navigation.destinations.taskComposable
import me.padamchopra.todocompose.util.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(
    navController: NavHostController
) {
    val screen = remember(navController) {
        Screens(navController)
    }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(
            navigateToTaskScreen = screen.task
        )
        taskComposable(
            navigateToListScreen = screen.list
        )
    }
}