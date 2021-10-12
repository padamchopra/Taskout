package me.padamchopra.todocompose.ui.screens.list

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import me.padamchopra.todocompose.R
import me.padamchopra.todocompose.ui.theme.ToDoComposeTheme
import me.padamchopra.todocompose.ui.theme.fabBackgroundColor
import me.padamchopra.todocompose.ui.viewmodels.SharedViewModel
import me.padamchopra.todocompose.util.SearchAppBarState

@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    val searchAppBarState: SearchAppBarState by sharedViewModel.searchAppBarState
    val searchTextState: String by sharedViewModel.searchTextState

    Scaffold(
        topBar = {
            ListAppBar(
                sharedViewModel = sharedViewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState
            )
        },
        content = {},
        floatingActionButton = {
            ListFab(navigateToTaskScreen)
        }
    )
}

@Composable
fun ListFab(
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    FloatingActionButton(
        onClick = {
        navigateToTaskScreen(-1)
        },
        backgroundColor = MaterialTheme.colors.fabBackgroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(
                id = R.string.add_button
            ),
            tint = Color.White
        )
    }
}

//@Composable
//@Preview()
//private fun PreviewListScreen() {
//    ListScreen(navigateToTaskScreen = {})
//}
//
//@Composable
//@Preview()
//private fun PreviewListScreenDark() {
//    ToDoComposeTheme(darkTheme = true) {
//        ListScreen(navigateToTaskScreen = {})
//    }
//}
