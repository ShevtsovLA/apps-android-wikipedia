package org.wikipedia.homeworks.homework08

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class OnboardingScreenTests : TestCase() {

    @get: Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    private val numOfPage = 3

    @Test
    fun skippingTest() {
        run{
            step("Skip button is displayed") {
                OnboardingScreen.skipButton.isDisplayed()
            }
            step("Skip button is clickable") {
                OnboardingScreen.skipButton.isClickable()
            }
        }
    }

    fun logoTest() {
        run {
            var page = 0
            repeat(numOfPage) {
                step("Image is displayed") {
                    OnboardingScreen.items.childAt<OnboardingScreenFirstItem>(page) {
                        image.isDisplayed()
                    }
                }
                step("Next page") {
                    OnboardingScreen.forwardButton.click()
                }
                page++
            }
        }
    }
}

