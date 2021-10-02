package me.padamchopra.todocompose.navigation

import androidx.navigation.NavHostController
import me.padamchopra.todocompose.util.Action
import me.padamchopra.todocompose.util.Constants.LIST_SCREEN

class Screens(navController: NavHostController) {
    val list: (Action) -> Unit = {
        navController.navigate("list/${it.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    val task: (Int) -> Unit = {
        navController.navigate("task/${it}")
    }
}