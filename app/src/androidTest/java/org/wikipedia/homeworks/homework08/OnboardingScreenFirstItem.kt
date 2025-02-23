package org.wikipedia.homeworks.homework08

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class OnboardingScreenFirstItem(matcher: Matcher<View>) :
    KViewPagerItem<OnboardingScreenFirstItem>(matcher) {

    val image = KImageView {
        withId(R.id.imageViewCentered)
    }

    val titleText = KTextView(matcher) {
        withId(R.id.primaryTextView)
    }
    val subtitleText = KTextView(matcher) {
        withId(R.id.secondaryTextView)
    }

    val languages = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.languageList)
        },
        itemTypeBuilder = {
            itemType (::LanguagesListItem)
        }
    )

    val addLanguageButton = KButton(matcher) {
        withId(R.id.addLanguageButton)
    }
}