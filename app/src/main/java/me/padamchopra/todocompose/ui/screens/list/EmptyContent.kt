package me.padamchopra.todocompose.ui.screens.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import me.padamchopra.todocompose.R
import me.padamchopra.todocompose.ui.theme.MediumEmphasisContentColor
import me.padamchopra.todocompose.ui.theme.SAD_FACE_ICON_SIZE
import me.padamchopra.todocompose.ui.theme.ToDoComposeTheme

@Composable
fun EmptyContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(SAD_FACE_ICON_SIZE),
            painter = painterResource(id = R.drawable.ic_sad_face),
            tint = MaterialTheme.colors.MediumEmphasisContentColor,
            contentDescription = stringResource(
                id = R.string.sad_face_desc
            )
        )
        Text(
            style = MaterialTheme.typography.h6,
            text = stringResource(id = R.string.empty_content),
            color = MaterialTheme.colors.MediumEmphasisContentColor,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun PreviewEmptyContent() {
    EmptyContent()
}

@Preview
@Composable
fun PreviewEmptyContentDark() {
    ToDoComposeTheme(darkTheme = true) {
        PreviewEmptyContent()
    }
}
