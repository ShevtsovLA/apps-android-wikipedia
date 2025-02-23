package org.wikipedia.homeworks.homework08

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object OnboardingScreen : KScreen<OnboardingScreen>(){
    override val layoutId = R.layout.fragment_onboarding_pager
    override val viewClass = null

    val items = KViewPager2(
        builder = {
            withId(R.id.fragment_pager)
        },
        itemTypeBuilder = {
            itemType(::OnboardingScreenFirstItem)
            itemType(::OnboardingScreenSecondItem)
        }
    )

    val skipButton = KButton {
        withId(R.id.fragment_onboarding_skip_button)
    }
    val forwardButton = KButton {
        withId(R.id.fragment_onboarding_forward_button)
    }
    val doneButton = KButton {
        withId(R.id.fragment_onboarding_done_button)
    }

}