package me.padamchopra.todocompose.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.padamchopra.todocompose.data.models.Priority
import me.padamchopra.todocompose.R
import me.padamchopra.todocompose.ui.theme.*

@Composable
fun PriorityDropDown(
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    val angle: Float by animateFloatAsState(targetValue = if (expanded) 180f else 0f)
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(PRIORITY_DROP_DOWN_HEIGHT)
            .clickable { expanded = true }
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
                shape = MaterialTheme.shapes.small
            )
            .background(MaterialTheme.colors.background),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Canvas(modifier = Modifier
            .size(PRIORITY_INDICATOR_SIZE)
            .weight(1f)) {
            drawCircle(color = priority.color)
        }
        Text(
            modifier = Modifier.weight(8f),
            text = priority.name,
            style = MaterialTheme.typography.subtitle2,
            color = MaterialTheme.colors.contentColor
        )
        IconButton(
            onClick = { expanded = true },
            modifier = Modifier
                .alpha(ContentAlpha.medium)
                .rotate(angle)
                .weight(1.5f)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = stringResource(id = R.string.more_options_btn),
                tint = MaterialTheme.colors.contentColor
            )
        }
        DropdownMenu(
            modifier = Modifier.fillMaxWidth().padding(horizontal = LARGE_PADDING),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onPrioritySelected(Priority.LOW)
                }
            ) {
                PriorityItem(priority = Priority.LOW)
            }
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onPrioritySelected(Priority.MEDIUM)
                }
            ) {
                PriorityItem(priority = Priority.MEDIUM)
            }
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onPrioritySelected(Priority.HIGH)
                }
            ) {
                PriorityItem(priority = Priority.HIGH)
            }
        }
    }
}

@Preview
@Composable
fun PreviewPriorityDropDown() {
    PriorityDropDown(
        priority = Priority.LOW,
        onPrioritySelected = {}
    )
}

@Preview
@Composable
fun PreviewPriorityDropDownDark() {
    ToDoComposeTheme(darkTheme = true) {
        PreviewPriorityDropDown()
    }
}
