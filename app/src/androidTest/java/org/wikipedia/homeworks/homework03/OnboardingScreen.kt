package org.wikipedia.homeworks.homework03

import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import org.wikipedia.views.AppTextView

val skipButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_skip_button",
    "onboarding_skip"
)

val continueButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_forward_button",
    "onboarding_continue"
)

val wikiLogo = listOf(
    AppCompatImageView::class.java,
    "imageViewCentered",
    null
)

val addLanguageButton = listOf(
    MaterialButton::class.java,
    "addLanguageButton",
    "onboarding_multilingual_add_language_text"
)

val languagesList = listOf(
    RecyclerView::class.java,
    "languagesList",
    null

)

val heading = listOf(
    AppTextView::class.java,
    "primaryTextView",
    "onboarding_welcome_title_v2"
)

val subtitle = listOf(
    AppTextView::class.java,
    "secondaryTextView",
    "onboarding_multilingual_secondary_text"
)
