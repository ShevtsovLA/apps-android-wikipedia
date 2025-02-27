package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class FeaturedArticleItem(matcher: Matcher<View>)
    : KRecyclerItem<FeaturedArticleItem>(matcher) {

    val titleText = KTextView {
        withId(R.id.view_card_header_title)
    }

    val image = KImageView {
        withId(R.id.articleImage)
    }

    val headerText = KTextView {
        withId(R.id.articleTitle)
    }

    val descriptionText = KTextView {
        withId(R.id.articleDescription)
    }

    val articleText = KTextView {
        withId(R.id.articleExtract)
    }
}