package org.wikipedia.homeworks.homework07

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class TopReadItem(matcher: Matcher<View>) : KRecyclerItem<TopReadItem>(matcher) {
    val headerText = KTextView(matcher) {
        withId(R.id.view_list_card_header)
    }
    val moreTopReadButton = KTextView(matcher) {
        withId(R.id.footerActionButton)
    }
    val dotesButton = KButton(matcher) {
        withId(R.id.view_list_card_header_menu)
    }
    val cardList = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.view_list_card_list)
        },
        itemTypeBuilder = {
            itemType(::TopReadCardItem)
        }
    )

}
