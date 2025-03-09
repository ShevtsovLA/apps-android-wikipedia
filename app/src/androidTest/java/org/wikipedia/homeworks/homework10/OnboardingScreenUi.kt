package org.wikipedia.homeworks.homework10

import com.kaspersky.components.kautomator.component.bottomnav.UiBottomNavigationView
import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingScreenUi : UiScreen<OnboardingScreenUi>() {

    override val packageName = "org.wikipedia.alpha"

    val image = UiView {
        withId(this@OnboardingScreenUi.packageName, "imageViewCentered")
    }

    val skipButton = UiButton {
        withId(this@OnboardingScreenUi.packageName, "fragment_onboarding_skip_button")
    }

    val continueButton = UiButton {
        withId(this@OnboardingScreenUi.packageName, "fragment_onboarding_forward_button")
    }

    val primaryText = UiTextView {
        withId(this@OnboardingScreenUi.packageName, "primaryTextView")
    }

    val secondaryText = UiTextView {
        withId(this@OnboardingScreenUi.packageName, "secondaryTextView")
    }

    val pageIndicator = UiBottomNavigationView {
        withId(this@OnboardingScreenUi.packageName, "view_onboarding_page_indicator")
    }

    val getStartedButton = UiButton {
        withId(this@OnboardingScreenUi.packageName, "fragment_onboarding_done_button")
    }
}