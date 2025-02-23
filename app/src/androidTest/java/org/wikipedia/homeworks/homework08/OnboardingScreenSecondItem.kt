package org.wikipedia.homeworks.homework08

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class OnboardingScreenSecondItem(matcher: Matcher<View>) :
    KViewPagerItem<OnboardingScreenSecondItem>(matcher) {
    val image = KImageView {
        withId(R.id.imageViewCentered)
    }

    val titleText = KTextView(matcher) {
        withId(R.id.primaryTextView)
    }
    val subtitleText = KTextView(matcher) {
        withId(R.id.secondaryTextView)
    }
}