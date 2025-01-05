package com.cevdetkilickeser.composenavigationtransitions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cevdetkilickeser.composenavigationtransitions.ui.theme.ComposeNavigationTransitionsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeNavigationTransitionsTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "screenA") {
                    composable(
                        route = "screenA",
                        exitTransition = {
                            slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Left,
                                tween(1000)
                            )
                        },
                        popEnterTransition = {
                            slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Right,
                                tween()
                            )
                        }
                    ) {
                        ScreenA(
                            onNavigateToScreenB = {
                                navController.navigate("screenB")
                            }
                        )
                    }
                    composable(
                        route = "screenB",
                        exitTransition = {
                            slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Left,
                                tween()
                            )
                        },
                        popEnterTransition = {
                            slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Right,
                                tween()
                            )
                        },
                        popExitTransition = {
                            slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Right,
                                tween()
                            )
                        }
                    ) {
                        ScreenB(
                            onNavigateToScreenC = {
                                navController.navigate("screenC")
                            },
                            onNavigateToBack = {
                                navController.popBackStack()
                            }
                        )
                    }
                    composable(
                        route = "screenC",
                        popExitTransition = {
                            slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Right,
                                tween()
                            )
                        }
                    ) {
                        ScreenC(
                            onNavigateToBack = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}