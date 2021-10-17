package me.padamchopra.todocompose.ui.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import me.padamchopra.todocompose.data.models.Priority
import me.padamchopra.todocompose.data.models.ToDoTask
import me.padamchopra.todocompose.ui.viewmodels.SharedViewModel
import me.padamchopra.todocompose.util.Action

@Composable
fun TaskScreen(
    sharedViewModel: SharedViewModel,
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {

    val title: String by sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority

    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = navigateToListScreen
            )
        },
        content = {
            TaskContent(
                title = title,
                onTitleChange = { sharedViewModel.updateTitle(it) },
                description = description,
                onDescriptionChange = { sharedViewModel.updateDescription(it) },
                priority = priority,
                onPrioritySelected = { sharedViewModel.updatePriority(it) }
            )
        }
    )
}
