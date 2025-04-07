package org.wikipedia.homeworks.homework13

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.FeaturedArticleItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity

class WebViewTest: TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webViewTest() {
        run{
            OnboardingScreen.skipButton.click()
            ExploreScreen.feed.childWith<FeaturedArticleItem> {
                withDescendant { withText("Featured article") }
            }.perform {
                click()
            }
            ArticleViewScreen{
                webView{
                    withElement(Locator.ID,"References") {
                        scroll()
                    }
                }
                webView{
                    withElement(Locator.ID,"References") {
                        hasText("References")
                    }
                }
                webView{
                    withElement(Locator.XPATH,"//*[@id='cite_ref-OBrien_5-0']") {
                        scroll()
                        click()
                    }
                }
            }
            PopUpScreen.number.hasText("5")
            device.uiDevice.pressBack()
            ArticleViewScreen{
                webView{
                    withElement(Locator.CSS_SELECTOR, ".mw-redirect[2]") {
                        click()
                    }
                }
            }
            ScrollScreen.readArticleButton.click()
            NewViewScreen{
                newWebView{
                    withElement(Locator.ID, "References"){
                        scroll()
                    }
                }
            }
        }
    }

}