package me.padamchopra.todocompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import me.padamchopra.todocompose.util.Action
import me.padamchopra.todocompose.util.Constants.TASK_ARGUMENT_KEY
import me.padamchopra.todocompose.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(
            navArgument(TASK_ARGUMENT_KEY) {type = NavType.IntType}
        )
    ) {

    }
}