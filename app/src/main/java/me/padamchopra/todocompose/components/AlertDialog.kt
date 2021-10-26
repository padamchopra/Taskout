package me.padamchopra.todocompose.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import me.padamchopra.todocompose.R

@Composable
fun DisplayAlertDialog(
    title: String,
    message: String,
    showDialog: Boolean,
    closeDialog: () -> Unit,
    onConfirmClicked: () -> Unit
) {
    if (showDialog) {
        AlertDialog(
            title = {
                Text(text = title)
            },
            text = {
                   Text(text = message)
            },
            confirmButton = {
                TextButton(onClick = {
                    onConfirmClicked()
                    closeDialog()
                }) {
                    Text(stringResource(id = R.string.generic_yes))
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    closeDialog()
                }) {
                    Text(stringResource(id = R.string.generic_no))
                }
            },
            onDismissRequest = { closeDialog() }
        )
    }
}
