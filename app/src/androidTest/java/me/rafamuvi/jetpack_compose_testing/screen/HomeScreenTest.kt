package me.rafamuvi.jetpack_compose_testing.screen

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import me.rafamuvi.jetpack_compose_testing.MainActivity
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {

    /*
    * This way you can set composables your way
    * Set state and information
    @get:Rule
    val composeTestRule = createComposeRule()
    *
    @Before
    fun setup() {
        composeTestRule.setContent {
            Jetpack_compose_testingTheme {
                var value by remember { mutableStateOf("") }

                SetupNavGraph(
                    navController = rememberNavController(),
                    inputFieldValue = value,
                    inputFieldOnValueChange = { value = it }
                )
            }
        }
    }
    */

    /*
    This is the simplest way
    You take the activity already set
    */
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun assertHomeScreenText() {
        /* You can find elements by a Test Tag and perform some actions
        */
        composeTestRule.onNode(hasTestTag("home_text"))
            .assertIsDisplayed()
            .assert(hasText("Home Screen"))
    }

    @Test
    fun assertHomeButtonIsDisable() {
        /* You can find elements by some attribute like "Text" and perform some actions
        */
        composeTestRule.onNode(hasText("Send to next Screen"))
            .assertIsDisplayed()
            .assertIsNotEnabled()
    }

    @Test
    fun assertHomeInputLabel() {
        /* You can find elements that has Test Tag directly with "onNodeWithTag"
        */
        composeTestRule.onNodeWithTag("home_input")
            .assertIsDisplayed()
            .assert(hasText("Type your name"))
    }

    @Test
    fun inputTextAndAssertNextScreen() {
        /* You can save your elements on variable to perform actions later
        * Note that button is from "SecondScreen" but you can save before and perform
        * action when it is "visible"
        */
        val someText = "Rafael Muniz"
        var input = composeTestRule.onNodeWithTag("home_input")
        var button = composeTestRule.onNodeWithTag("home_button")
        var textOnDetailScreen = composeTestRule.onNodeWithTag("detail_name")

        input.performTextInput(someText)
        button.performClick()
        textOnDetailScreen.assertTextEquals("Hello $someText!")
    }
}
