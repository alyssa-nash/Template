package com.example.template.feature.basic

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.template.core.ui.TemplateTheme

// This is all stubbing for now and will bre replaced with real content

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    TemplateTheme {
        Greeting("Android")
    }
}
