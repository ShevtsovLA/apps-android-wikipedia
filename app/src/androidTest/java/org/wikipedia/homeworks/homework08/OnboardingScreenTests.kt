package org.wikipedia.homeworks.homework08

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class OnboardingScreenTests : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get: Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

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

    @Test
    fun logoTest1() {
        run {
                step("Image is displayed") {
                    OnboardingScreen.items.childAt<OnboardingScreenFirstItem>(0) {
                        image.isDisplayed()
                    }
                }
                step("Next page") {
                    OnboardingScreen.forwardButton.click()
                }

        }
    }

    @Test
    fun logoTest2() {
        run {
            step("Image is displayed") {
                OnboardingScreen.items.childAt<OnboardingScreenSecondItem>(0) {
                    image.isDisplayed()
                }
            }
            step("Next page") {
                OnboardingScreen.forwardButton.click()
            }

        }
    }
}

