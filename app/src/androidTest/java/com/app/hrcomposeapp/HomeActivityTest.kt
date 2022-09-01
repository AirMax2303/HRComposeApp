package com.app.hrcomposeapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.app.hrcomposeapp.views.HomeActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<HomeActivity>()
    // use createAndroidComposeRule<YourActivity>() if you need access to
    // an activity or use createComposeRule()

    @Test
    fun add_fab_test() {
        val addFABText = composeTestRule.activity.getString(R.string.desc_add_fab)
        val addEmployeeText = composeTestRule.activity.getString(R.string.add_employee)
        composeTestRule.onNodeWithContentDescription(addFABText).performClick()
        composeTestRule.onNodeWithText(addEmployeeText, useUnmergedTree = true).assertIsDisplayed()
    }

}
