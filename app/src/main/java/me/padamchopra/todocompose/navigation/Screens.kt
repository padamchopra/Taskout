package me.padamchopra.todocompose.navigation

import androidx.navigation.NavHostController
import me.padamchopra.todocompose.util.Action
import me.padamchopra.todocompose.util.Constants.LIST_SCREEN
import me.padamchopra.todocompose.util.Constants.SPLASH_SCREEN

class Screens(navController: NavHostController) {
    val splash: () -> Unit = {
        navController.navigate(route = "list/${Action.NO_ACTION.name}") {
            popUpTo(SPLASH_SCREEN) { inclusive = true }
        }
    }

    val task: (Action) -> Unit = {
        navController.navigate("list/${it.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    val list: (Int) -> Unit = {
        navController.navigate("task/${it}")
    }
}