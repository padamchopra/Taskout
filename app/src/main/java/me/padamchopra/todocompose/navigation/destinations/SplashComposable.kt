package me.padamchopra.todocompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import me.padamchopra.todocompose.ui.screens.splash.SplashScreen
import me.padamchopra.todocompose.util.Constants

fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit
) {
    composable(
        route = Constants.SPLASH_SCREEN
    ) {
        SplashScreen(
             navigateToListScreen = navigateToListScreen
        )
    }
}
