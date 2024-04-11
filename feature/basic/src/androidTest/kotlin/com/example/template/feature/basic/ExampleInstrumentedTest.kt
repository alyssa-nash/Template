package com.example.template.feature.basic

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import de.mannodermaus.junit5.compose.createComposeExtension
import org.junit.jupiter.api.Test

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(androidx.compose.ui.test.ExperimentalTestApi::class)
class ExampleInstrumentedTest {
    private val extension = createComposeExtension()

    @Test
    fun greetingMessageDisplayed() {
        extension.use {
            val testName = "Android"
            setContent {
                Greeting(name = "Android", modifier = Modifier)
            }

            onNodeWithText("Hello $testName!")
                .assertIsDisplayed()
        }
    }
}
