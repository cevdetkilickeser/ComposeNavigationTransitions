package com.cevdetkilickeser.composenavigationtransitions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cevdetkilickeser.composenavigationtransitions.ui.theme.ComposeNavigationTransitionsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeNavigationTransitionsTheme {
                val navController = rememberNavController()
                val currentBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = currentBackStackEntry?.destination?.route

                Scaffold(
                    bottomBar = {
                        if (currentRoute in bottomBarScreens) {
                            BottomBar(navController)
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = Screen.Home.route
                    ) {
                        composable(
                            route = Screen.Home.route,
                            exitTransition = {
                                slideOutOfContainer(
                                    AnimatedContentTransitionScope.SlideDirection.Left,
                                    tween()
                                )
                            }
                        ) {
                            Home(
                                onNavigateToScreenA = {
                                    navController.navigate("screenA")
                                }
                            )
                        }
                        composable(
                            route = Screen.Profile.route,
                        ){
                            Profile()
                        }
                        composable(
                            route = Screen.ScreenA.route,
                            enterTransition = {
                                slideIntoContainer(
                                    AnimatedContentTransitionScope.SlideDirection.Left,
                                    tween()
                                )
                            },
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
                                    AnimatedContentTransitionScope.SlideDirection.Right
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
                            route = Screen.ScreenB.route,
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
                            route = Screen.ScreenC.route,
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
}