package me.padamchopra.todocompose.ui.screens.task

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import me.padamchopra.todocompose.R
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

    val snackBarMessage = stringResource(id = R.string.task_invalid_error)
    val snackBarHostState = remember { SnackbarHostState() }

    Scaffold(
        scaffoldState = rememberScaffoldState(snackbarHostState = snackBarHostState),
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = { action ->
                    if (action == Action.NO_ACTION || sharedViewModel.validateFields() ) {
                        navigateToListScreen(action)
                    } else {
                        sharedViewModel.showTaskSnackBar(
                            snackBarHostState = snackBarHostState,
                            message = snackBarMessage
                        )
                    }
                }
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
