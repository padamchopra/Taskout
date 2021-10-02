package me.padamchopra.todocompose.data.models

import androidx.compose.ui.graphics.Color
import me.padamchopra.todocompose.ui.theme.HighPriorityColor
import me.padamchopra.todocompose.ui.theme.LowPriorityColor
import me.padamchopra.todocompose.ui.theme.MediumPriorityColor
import me.padamchopra.todocompose.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}