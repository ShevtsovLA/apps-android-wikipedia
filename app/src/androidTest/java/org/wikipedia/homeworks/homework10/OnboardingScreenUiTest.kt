package org.wikipedia.homeworks.homework10

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class OnboardingScreenUiTest: TestCase() {

    @get: Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun firstPageUiTest() {
        run {
            step("Primary text on start page has text") {
                OnboardingScreenUi.primaryText.containsText("The Free Encyclopedia")
            }
            step("Secondary text on start page has text") {
                OnboardingScreenUi.secondaryText.containsText("the following on your device")
            }
            step("Skip button contains text") {
                OnboardingScreenUi.skipButton.containsText("Skip")
            }
            step("Continue button contains text") {
                OnboardingScreenUi.continueButton.containsText("Continue")
            }

        }
    }


    @Test
    fun secondPageUiTest() {
        run {
            step("Next page") {
                OnboardingScreenUi.continueButton.click()
            }
            step("Primary text on second page has text") {
                OnboardingScreenUi.primaryText.containsText("ways to explore")
            }
            step("Secondary text on second page has text") {
                OnboardingScreenUi.secondaryText.containsText("the Wikipedia rabbit hole")
            }
            step("Skip button contains text") {
                OnboardingScreenUi.skipButton.containsText("Skip")
            }
            step("Continue button contains text") {
                OnboardingScreenUi.continueButton.containsText("Continue")
            }

        }
    }

    @Test
    fun thirdPageUiTest() {
        run {
            step("Next page") {
                OnboardingScreenUi.continueButton.click()
            }
            step("Next page") {
                OnboardingScreenUi.continueButton.click()
            }
            step("Primary text on third page has text") {
                OnboardingScreenUi.primaryText.containsText("lists with sync")
            }
            step("Secondary text on third page has text") {
                OnboardingScreenUi.secondaryText.containsText("reading lists from articles")
            }
            step("Skip button contains text") {
                OnboardingScreenUi.skipButton.containsText("Skip")
            }
            step("Continue button contains text") {
                OnboardingScreenUi.continueButton.containsText("Continue")
            }

        }
    }

    @Test
    fun lastPageUiTest() {
        run {
            step("Next page") {
                OnboardingScreenUi.continueButton.click()
            }
            step("Next page") {
                OnboardingScreenUi.continueButton.click()
            }
            step("Next page") {
                OnboardingScreenUi.continueButton.click()
            }
            step("Primary text on last page has text") {
                OnboardingScreenUi.primaryText.containsText("Data")
            }
            step("Secondary text on last page has text") {
                OnboardingScreenUi.secondaryText.containsText("personal information")
            }
            step("Get started button contains text") {
                OnboardingScreenUi.getStartedButton.containsText("Get started")
            }

        }
    }
}
