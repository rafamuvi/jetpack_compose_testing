package me.rafamuvi.jetpack_compose_testing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import me.rafamuvi.jetpack_compose_testing.screen.navigation.SetupNavGraph
import me.rafamuvi.jetpack_compose_testing.ui.theme.Jetpack_compose_testingTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_compose_testingTheme {
                var value by remember { mutableStateOf("") }

                navController = rememberNavController()
                SetupNavGraph(
                    navController = navController,
                    inputFieldValue = value,
                    inputFieldOnValueChange = { value = it }
                )
            }
        }
    }
}
