package me.rafamuvi.jetpack_compose_testing.screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun InputField(
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable (() -> Unit)?,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = label,
        modifier = modifier,
        shape = RoundedCornerShape(50)
    )
}

@Preview(showBackground = true)
@Composable
fun InputPreview() {

    var value by remember { mutableStateOf("") }

    InputField(
        value = value,
        onValueChange = { value = it },
        label = { Text(text = "Enter your name") },
        modifier = Modifier.fillMaxWidth()
    )
}
