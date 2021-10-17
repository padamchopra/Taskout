package me.padamchopra.todocompose.ui.screens.task

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import me.padamchopra.todocompose.ui.theme.topAppBarBackgroundColor
import me.padamchopra.todocompose.ui.theme.topAppBarContentColor
import me.padamchopra.todocompose.util.Action
import me.padamchopra.todocompose.R
import me.padamchopra.todocompose.data.models.Priority
import me.padamchopra.todocompose.data.models.ToDoTask
import me.padamchopra.todocompose.ui.theme.ToDoComposeTheme

@Composable
fun TaskAppBar(
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {
    if (selectedTask == null) {
        NewTaskAppBar(navigateToListScreen = navigateToListScreen)
    } else {
        ExistingTaskAppBar(
            selectedTask = selectedTask,
            navigateToListScreen = navigateToListScreen
        )
    }
}

@Composable
fun NewTaskAppBar(
    navigateToListScreen: (Action) -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Add Task",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        navigationIcon = {
            BackAction(onBackClicked = navigateToListScreen)
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            AddAction(onAddClicked = navigateToListScreen)
        }
    )
}

@Composable
fun BackAction(
    onBackClicked:(Action) -> Unit
) {
    IconButton(onClick = {
        onBackClicked(Action.NO_ACTION)
    }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(id = R.string.back_button),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun AddAction(
    onAddClicked:(Action) -> Unit
) {
    IconButton(onClick = {
        onAddClicked(Action.ADD)
    }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(id = R.string.add_button),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun ExistingTaskAppBar(
    selectedTask: ToDoTask,
    navigateToListScreen: (Action) -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = selectedTask.title,
                color = MaterialTheme.colors.topAppBarContentColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            CloseAction(onCloseClicked = navigateToListScreen)
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            DeleteAction(onDeleteClicked = navigateToListScreen)
            UpdateAction(onUpdateClicked = navigateToListScreen)
        }
    )
}

@Composable
fun CloseAction(
    onCloseClicked:(Action) -> Unit
) {
    IconButton(onClick = {
        onCloseClicked(Action.NO_ACTION)
    }) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = stringResource(id = R.string.generic_close_btn),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun DeleteAction(
    onDeleteClicked:(Action) -> Unit
) {
    IconButton(onClick = {
        onDeleteClicked(Action.DELETE)
    }) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = stringResource(id = R.string.delete_btn),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun UpdateAction(
    onUpdateClicked:(Action) -> Unit
) {
    IconButton(onClick = {
        onUpdateClicked(Action.UPDATE)
    }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(id = R.string.update_btn),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Preview
@Composable
fun PreviewNewTaskAppBar() {
    NewTaskAppBar(navigateToListScreen = {})
}

@Preview
@Composable
fun PreviewNewTaskAppBarDark() {
    ToDoComposeTheme(darkTheme = true) {
        PreviewNewTaskAppBar()
    }
}

@Preview
@Composable
fun PreviewExistingTaskAppBar() {
    ExistingTaskAppBar(
        selectedTask = ToDoTask(
            id = 0,
            title = "Lorem Ipsum",
            description = "Lorem ipsum dolor sit amet.",
            priority = Priority.LOW
        ),
        navigateToListScreen = {}
    )
}

@Preview
@Composable
fun PreviewExistingTaskAppBarDark() {
    ToDoComposeTheme(darkTheme = true) {
        PreviewExistingTaskAppBar()
    }
}
