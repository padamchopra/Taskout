package me.padamchopra.todocompose.navigation.destinations

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import me.padamchopra.todocompose.ui.screens.task.TaskScreen
import me.padamchopra.todocompose.ui.viewmodels.SharedViewModel
import me.padamchopra.todocompose.util.Action
import me.padamchopra.todocompose.util.Constants.TASK_ARGUMENT_KEY
import me.padamchopra.todocompose.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(
            navArgument(TASK_ARGUMENT_KEY) {type = NavType.IntType}
        )
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        LaunchedEffect(key1 = taskId) {
            sharedViewModel.getSelectedTask(taskId = taskId)
        }

        val selectedTask by sharedViewModel.selectedTask.collectAsState()
        LaunchedEffect(key1 = selectedTask) {
            if (selectedTask != null || taskId == -1) {
                sharedViewModel.updateTaskFields(selectedTask = selectedTask)
            }
        }

        TaskScreen(
            sharedViewModel = sharedViewModel,
            selectedTask = selectedTask,
            navigateToListScreen = navigateToListScreen
        )
    }
}