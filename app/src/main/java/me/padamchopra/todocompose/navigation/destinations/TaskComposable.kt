package me.padamchopra.todocompose.navigation.destinations

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import me.padamchopra.todocompose.ui.screens.task.TaskScreen
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
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        Log.d("TaskComposable", "Opening task screen for task id: $taskId")
        
        TaskScreen(navigateToListScreen = navigateToListScreen)
    }
}