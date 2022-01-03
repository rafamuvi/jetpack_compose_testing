package me.rafamuvi.jetpack_compose_testing.screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    buttonColor: Color = MaterialTheme.colors.primary,
    textColor: Color = Color.White,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = buttonColor,
            contentColor = textColor
        ),
        enabled = enabled,
        shape = RoundedCornerShape(50),
        onClick = onClick
    ) {
        Text(text = text, style = TextStyle(fontSize = 20.sp))
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    CustomButton(
        modifier = Modifier,
        text = "Go to next screen"
    ) {
    }
}
