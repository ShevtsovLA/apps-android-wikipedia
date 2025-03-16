package org.wikipedia.homeworks.homework13

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R

object NewViewScreen: KScreen<NewViewScreen>() {
    override val layoutId = null
    override val viewClass = null

    val newWebView = KWebView {
        withId(R.id.page_web_view)
    }
}