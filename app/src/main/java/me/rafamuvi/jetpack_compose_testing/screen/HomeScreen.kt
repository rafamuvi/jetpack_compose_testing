package me.rafamuvi.jetpack_compose_testing.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import me.rafamuvi.jetpack_compose_testing.R
import me.rafamuvi.jetpack_compose_testing.screen.components.CustomButton
import me.rafamuvi.jetpack_compose_testing.screen.components.InputField
import me.rafamuvi.jetpack_compose_testing.screen.navigation.Screen

@Composable
fun HomeScreen(
    navController: NavHostController,
    inputFieldValue: String,
    inputFieldOnValueChange: (String) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.home_screen),
                style = TextStyle(fontSize = 30.sp),
                modifier = Modifier.testTag("home_text")
            )
            Spacer(modifier = Modifier.padding(30.dp))
            InputField(
                value = inputFieldValue,
                onValueChange = inputFieldOnValueChange,
                label = { Text(text = stringResource(R.string.home_input_field_label)) },
                modifier = Modifier.fillMaxWidth().testTag("home_input")
            )
            Spacer(modifier = Modifier.padding(30.dp))
            CustomButton(
                text = stringResource(R.string.home_btn_text),
                modifier = Modifier.testTag("home_button"),
                enabled = inputFieldValue != ""
            ) {
                navController.navigate(Screen.Detail.passName(inputFieldValue))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    var value by remember { mutableStateOf("") }
    HomeScreen(
        inputFieldValue = value,
        inputFieldOnValueChange = { value = it },
        navController = rememberNavController()
    )
}
