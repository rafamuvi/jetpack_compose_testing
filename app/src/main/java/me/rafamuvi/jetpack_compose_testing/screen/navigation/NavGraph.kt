package me.rafamuvi.jetpack_compose_testing.screen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import me.rafamuvi.jetpack_compose_testing.screen.DetailScreen
import me.rafamuvi.jetpack_compose_testing.screen.HomeScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    inputFieldValue: String,
    inputFieldOnValueChange: (String) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                inputFieldValue = inputFieldValue,
                inputFieldOnValueChange = inputFieldOnValueChange,
                navController = navController
            )
        }
        composable(
            Screen.Detail.route,
            arguments = listOf(
                navArgument(DETAIL_ARG_NAME) {
                    type = NavType.StringType
                }
            )
        ) {
            DetailScreen(navController = navController, it.arguments?.getString(DETAIL_ARG_NAME).toString())
        }
    }
}
