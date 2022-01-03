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

@Composable
fun DetailScreen(
    navController: NavHostController,
    name: String
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
                text = stringResource(R.string.detail_screen),
                style = TextStyle(fontSize = 30.sp),
                modifier = Modifier.testTag("detail_text")
            )
            Spacer(modifier = Modifier.padding(30.dp))
            Text(
                text = "Hello $name!",
                style = TextStyle(fontSize = 30.sp),
                modifier = Modifier.testTag("detail_name")
            )
            Spacer(modifier = Modifier.padding(30.dp))
            CustomButton(
                text = stringResource(R.string.detail_btn_text),
                modifier = Modifier.testTag("detail_button")
            ) {
                navController.popBackStack()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailPreview() {
    DetailScreen(navController = rememberNavController(), "Your Name")
}
