package org.wikipedia.homeworks.homework09

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework03.OnboardingScreenOld
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.InTheNewsCardItem
import org.wikipedia.homeworks.homework07.InTheNewsItem
import org.wikipedia.main.MainActivity

class InTheNewsTest : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get: Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun simpleTest() {
        run{
            step("Skipping") {
                OnboardingScreenOld.skipButton.click()
            }
            step("Title contains `Featured article`") {
                ExploreScreen.feed.childWith<InTheNewsItem> {
                    withDescendant {
                        withText("In the news")
                    }
                }
            }
            step("Getting on the third page") {
                ExploreScreen.feed.childWith<InTheNewsItem> {
                    withDescendant {
                        withText("In the news")
                    }
                }.perform {
                    inTheNewsItems.childAt<InTheNewsCardItem>(2) {
                        newsCardImage.click()
                    }
                }
            }
            step("Opening second article") {
                NewsStoryScreen.items.childAt<NewsCardItem>(1) {
                    cardTitleText.click()
                }
            }
            step("Checking for element with ID page_web_view") {
                NewsPage.pageWebView.isDisplayed()
            }
        }
    }
}