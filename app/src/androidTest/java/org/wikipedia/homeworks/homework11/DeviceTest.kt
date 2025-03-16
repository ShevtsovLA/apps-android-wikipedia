package org.wikipedia.homeworks.homework11

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.uiautomator.UiSelector
import com.kaspersky.kaspresso.device.exploit.Exploit
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.InTheNewsCardItem
import org.wikipedia.homeworks.homework07.InTheNewsItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework08.OnboardingScreenFirstItem
import org.wikipedia.homeworks.homework09.NewsCardItem
import org.wikipedia.homeworks.homework09.NewsPage
import org.wikipedia.homeworks.homework09.NewsStoryScreen
import org.wikipedia.main.MainActivity
import java.util.Locale

class DeviceTest: TestCase() {

    @get: Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun deviceTest() {
        before {

        }.after {
            device.network.enable()
            device.network.toggleWiFi(true)
            device.exploit.setOrientation(Exploit.DeviceOrientation.Portrait)
            device.language.switchInApp(Locale.ENGLISH)
        }.run {
            step("Поворот экрана и проверка ориентации") {
                device.exploit.setOrientation(Exploit.DeviceOrientation.Landscape)
                Thread.sleep(1000)
                if (!device.uiDevice.isNaturalOrientation) {
                    device.exploit.setOrientation(Exploit.DeviceOrientation.Portrait)
                }
            }
            step("Выключение экрана, включение экрана и проверка отображения элемента") {
                device.uiDevice.sleep()
                Thread.sleep(1000)
                device.uiDevice.wakeUp()
                OnboardingScreen.items.childAt<OnboardingScreenFirstItem>(0) {
                    image.isDisplayed()
                }
            }
            step ("Свернуть приложение и развернуть, проверить отображение элемента") {
                device.uiDevice.pressHome()
                device.uiDevice.pressRecentApps()
                Thread.sleep(1000)
                device.uiDevice.pressRecentApps()
                OnboardingScreen.skipButton.isDisplayed()
            }
            step("Переходим на Explore screen") {
                OnboardingScreen.skipButton.click()
                device.uiDevice.waitForIdle()
                Thread.sleep(1000)
            }
            step("Открываем первую картинку в In the news") {
                ExploreScreen.feed.childWith<InTheNewsItem> {
                    withDescendant {
                        withText("In the news")
                    }
                }.perform {
                    inTheNewsItems.childAt<InTheNewsCardItem>(0) {
                        newsCardImage.click()
                    }
                }
            }
            step("Выключить сеть, проверить отображение ошибки и кнопки Retry") {
                device.network.toggleWiFi(false)
                device.network.disable()
                NewsStoryScreen.items.childAt<NewsCardItem>(1) {
                    cardTitleText.click()
                }
                if (device.uiDevice.findObject(UiSelector().text("Retry")).exists()) {
                    device.network.toggleWiFi(true)
                    device.network.enable()
                    device.uiDevice.waitForIdle()
                    Thread.sleep(5000)
                    device.uiDevice.findObject(UiSelector().text("Retry")).click()
                }
            }
            step("Проверка элемента") {
                NewsPage.articleTitle.hasAnyText()
            }
//            step("Проверка текста кнопки после смены языка") {
//                device.language.switchInApp(Locale.FRANCE)
//            }
            step("Проверяем, что сейчас активна MainActivity") {
                device.activities.isCurrent(MainActivity::class.java)
            }
        }
    }
}