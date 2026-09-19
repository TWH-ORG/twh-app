package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ui.components.TechAppBar
import com.example.ui.components.TechBackgroundWrapper
import com.example.ui.components.TechBottomNav
import com.example.ui.components.TechDrawerContent
import com.example.ui.navigation.NavDestinations
import com.example.ui.screens.AboutScreen
import com.example.ui.screens.ContactScreen
import com.example.ui.screens.CourseDetailScreen
import com.example.ui.screens.CoursesScreen
import com.example.ui.screens.FaqScreen
import com.example.ui.screens.FreeLearningScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.ProfileScreen
import com.example.ui.screens.RegistrationScreen
import com.example.ui.screens.SettingsScreen
import com.example.ui.screens.SplashScreen
import com.example.ui.screens.YouTubeScreen
import com.example.ui.theme.TwhOrgTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TwhOrgTheme {
                TwhOrgApp()
            }
        }
    }
}

@Composable
fun TwhOrgApp() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val isSplashScreen = currentRoute == NavDestinations.SPLASH

    // Back handler for closing drawer if open
    BackHandler(enabled = drawerState.isOpen) {
        coroutineScope.launch { drawerState.close() }
    }

    val topLevelRoutes = listOf(
        NavDestinations.HOME,
        NavDestinations.COURSES,
        NavDestinations.FREE_LEARNING,
        NavDestinations.YOUTUBE,
        NavDestinations.PROFILE
    )

    val isTopLevel = currentRoute in topLevelRoutes
    val showBackButton = !isTopLevel && !isSplashScreen

    val screenTitle = when {
        currentRoute == NavDestinations.HOME -> "TWH ORG"
        currentRoute == NavDestinations.ABOUT -> "About TWH ORG"
        currentRoute == NavDestinations.COURSES -> "Courses"
        currentRoute?.startsWith("course_detail") == true -> "Course Details"
        currentRoute == NavDestinations.FREE_LEARNING -> "Free Learning"
        currentRoute == NavDestinations.YOUTUBE -> "TWH YouTube"
        currentRoute?.startsWith("registration") == true -> "Registration"
        currentRoute == NavDestinations.CONTACT -> "Contact Us"
        currentRoute == NavDestinations.FAQ -> "FAQ"
        currentRoute == NavDestinations.PROFILE -> "Student Profile"
        currentRoute == NavDestinations.SETTINGS -> "Settings"
        else -> "TWH ORG"
    }

    fun navigateTo(route: String) {
        coroutineScope.launch { drawerState.close() }
        navController.navigate(route) {
            popUpTo(NavDestinations.HOME) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    if (isSplashScreen) {
        SplashScreen(
            onSplashFinished = {
                navController.navigate(NavDestinations.HOME) {
                    popUpTo(NavDestinations.SPLASH) { inclusive = true }
                }
            }
        )
    } else {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                TechDrawerContent(
                    currentRoute = currentRoute,
                    onNavigate = { route -> navigateTo(route) },
                    onCloseDrawer = { coroutineScope.launch { drawerState.close() } }
                )
            }
        ) {
            Scaffold(
                topBar = {
                    TechAppBar(
                        title = screenTitle,
                        showBackButton = showBackButton,
                        onBackClick = { navController.popBackStack() },
                        onMenuClick = { coroutineScope.launch { drawerState.open() } }
                    )
                },
                bottomBar = {
                    TechBottomNav(
                        currentRoute = currentRoute,
                        onNavigate = { route -> navigateTo(route) }
                    )
                }
            ) { innerPadding ->
                TechBackgroundWrapper(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = NavDestinations.HOME,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        composable(NavDestinations.HOME) {
                            HomeScreen(
                                onNavigateToCourses = { navigateTo(NavDestinations.COURSES) },
                                onNavigateToFreeLearning = { navigateTo(NavDestinations.FREE_LEARNING) },
                                onNavigateToCourseDetail = { courseId ->
                                    navController.navigate(NavDestinations.createCourseDetailRoute(courseId))
                                },
                                onNavigateToRegister = { courseName ->
                                    navController.navigate(NavDestinations.createRegistrationRoute(courseName))
                                }
                            )
                        }

                        composable(NavDestinations.ABOUT) {
                            AboutScreen(
                                onNavigateToCourses = { navigateTo(NavDestinations.COURSES) },
                                onNavigateToRegister = { navigateTo(NavDestinations.REGISTRATION) }
                            )
                        }

                        composable(NavDestinations.COURSES) {
                            CoursesScreen(
                                onNavigateToCourseDetail = { courseId ->
                                    navController.navigate(NavDestinations.createCourseDetailRoute(courseId))
                                },
                                onNavigateToRegister = { courseName ->
                                    navController.navigate(NavDestinations.createRegistrationRoute(courseName))
                                }
                            )
                        }

                        composable(
                            route = NavDestinations.COURSE_DETAIL,
                            arguments = listOf(navArgument("courseId") { type = NavType.StringType })
                        ) { backStackEntry ->
                            val courseId = backStackEntry.arguments?.getString("courseId") ?: "cyber_security"
                            CourseDetailScreen(
                                courseId = courseId,
                                onNavigateBack = { navController.popBackStack() },
                                onNavigateToRegister = { courseName ->
                                    navController.navigate(NavDestinations.createRegistrationRoute(courseName))
                                }
                            )
                        }

                        composable(NavDestinations.FREE_LEARNING) {
                            FreeLearningScreen(
                                onNavigateToYouTube = { navigateTo(NavDestinations.YOUTUBE) }
                            )
                        }

                        composable(NavDestinations.YOUTUBE) {
                            YouTubeScreen()
                        }

                        composable(
                            route = NavDestinations.REGISTRATION,
                            arguments = listOf(
                                navArgument("courseId") {
                                    type = NavType.StringType
                                    nullable = true
                                    defaultValue = null
                                }
                            )
                        ) { backStackEntry ->
                            val course = backStackEntry.arguments?.getString("courseId")
                            RegistrationScreen(
                                initialCourse = course,
                                onRegistrationCompleted = {
                                    // Stays on screen to display success details & review
                                }
                            )
                        }

                        composable(NavDestinations.CONTACT) {
                            ContactScreen()
                        }

                        composable(NavDestinations.FAQ) {
                            FaqScreen()
                        }

                        composable(NavDestinations.PROFILE) {
                            ProfileScreen(
                                onNavigate = { route -> navigateTo(route) }
                            )
                        }

                        composable(NavDestinations.SETTINGS) {
                            SettingsScreen(
                                onNavigateToContact = { navigateTo(NavDestinations.CONTACT) }
                            )
                        }
                    }
                }
            }
        }
    }
}
