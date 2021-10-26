package me.padamchopra.todocompose.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.padamchopra.todocompose.data.models.Priority
import me.padamchopra.todocompose.ui.theme.LARGE_PADDING
import me.padamchopra.todocompose.ui.theme.PRIORITY_INDICATOR_SIZE
import me.padamchopra.todocompose.ui.theme.ToDoComposeTheme

@Composable
fun PriorityItem(priority: Priority) {
    Row (
        verticalAlignment = Alignment.CenterVertically
    ) {
        Canvas(modifier = Modifier.size(PRIORITY_INDICATOR_SIZE)) {
            drawCircle(color = priority.color)
        }
        Text(
            modifier = Modifier.padding(start = LARGE_PADDING),
            text = priority.name,
            style = MaterialTheme.typography.subtitle2,
            color = MaterialTheme.colors.onSurface
        )
    }
}

@Composable
@Preview
fun PriorityItemPreview() {
    PriorityItem(priority = Priority.LOW)
}

@Composable
@Preview
fun PriorityItemPreviewDark() {
    ToDoComposeTheme(darkTheme = true) {
        PriorityItemPreview()
    }
}
