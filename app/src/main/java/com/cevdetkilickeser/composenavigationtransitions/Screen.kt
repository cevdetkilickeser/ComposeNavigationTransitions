package com.cevdetkilickeser.composenavigationtransitions

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Profile : Screen("profile")
    data object ScreenA : Screen("screenA")
    data object ScreenB : Screen("screenB")
    data object ScreenC : Screen("screenC")
}

val bottomBarScreens = listOf(
    Screen.Home.route,
    Screen.Profile.route
)

