package org.wikipedia.homeworks.homework08


import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework03.OnboardingScreenOld
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.FeaturedArticleItem
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework07.TopReadCardItem
import org.wikipedia.homeworks.homework07.TopReadItem
import org.wikipedia.main.MainActivity

class ExploreScreenTests : TestCase() {

    @get: Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun simpleTest() {
        run {
            step("Skipping") {
                OnboardingScreenOld.skipButton.click()
            }
            step("Проверяет отображение тулбара") {
                ExploreScreen.toolbarTitle.isDisplayed()
            }
            step("Checking logo of mic in search") {
                ExploreScreen.feed.childAt<SearchCardViewItem>(0) {
                    voiceIcon.isDisplayed()
                }
            }
//            step("Checking has logo in 2nd child in topRead") {
//                ExploreScreen.feed.swipeUp()
//                ExploreScreen.feed.childAt<TopReadItem>(4) {
//                    step("TopReadItem.isDisplayed()") {
//                        isDisplayed()
//                    }
//
//                    cardList.childAt<TopReadCardItem>(1) {
//                        image.isDisplayed()
//                    }
//                }
//            }
            step("Title contains `Featured article`") {
                ExploreScreen.feed.childWith<TopReadItem> {
                    withDescendant {
                        withText("Top read")
                    }
//                    onPosition(3)
                }.perform {
//                    titleText.hasText("Featured article")
//                    image.isDisplayed()
//                    headerText.hasAnyText()
//                    descriptionText.hasAnyText()
                    dotesButton.isClickable()
                }
            }
        }
    }
}