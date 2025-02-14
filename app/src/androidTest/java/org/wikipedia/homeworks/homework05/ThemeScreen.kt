package org.wikipedia.homeworks.homework05

import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.button.MaterialButton
import com.google.android.material.materialswitch.MaterialSwitch
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.views.DiscreteSeekBar

val readingSettingCategory = KTextView {
    withText(R.string.theme_category_reading)
    withId(R.id.textSettingsCategory)
    isInstanceOf(MaterialTextView::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
    }
}

val textSizeInPercents = KTextView {
    withId(R.id.text_size_percent)
    isInstanceOf(MaterialTextView::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
    }
}

val textSizeBar = KSeekBar {
    withId(R.id.text_size_seek_bar)
    isEnabled()
    isInstanceOf(DiscreteSeekBar::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
    }
}

val lowSizeTextButton = KTextView {
    withId(R.id.buttonDecreaseTextSize)
    withText(R.string.text_size_decrease)
    isInstanceOf(MaterialTextView::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
    }
}

val kingSizeTextButton = KTextView {
    withId(R.id.buttonIncreaseTextSize)
    withText(R.string.text_size_increase)
    isInstanceOf(MaterialTextView::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
    }
}

val glassesImage = KImageView {
    withDrawable(R.drawable.ic_icon_reading_focus_mode)
    withParent {
        isInstanceOf(LinearLayout::class.java)
    }
    isInstanceOf(AppCompatImageView::class.java)
}

val readingFocusModeSwitcher = KSwitch {
    withId(R.id.theme_chooser_reading_focus_mode_switch)
    withText(R.string.reading_focus_mode)
    isInstanceOf(MaterialSwitch::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
    }
}

val readingFocusModeDescription = KTextView {
    withId(R.id.theme_chooser_reading_focus_mode_description)
    withText(R.string.reading_focus_mode_detail)
    isInstanceOf(MaterialTextView::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
    }
}

val themeSettingCategory = KTextView {
    withText(R.string.color_theme_select)
    isInstanceOf(MaterialTextView::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
    }
}

val lightTextThemeButton = KTextView {
    withId(R.id.button_theme_light)
    isInstanceOf(MaterialButton::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
    }
}

val sepiaTextThemeButton = KTextView {
    withId(R.id.button_theme_sepia)
    isInstanceOf(MaterialButton::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
    }
}

val darkTextThemeButton = KTextView {
    withId(R.id.button_theme_dark)
    isInstanceOf(MaterialButton::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
    }
}

val blackTextThemeButton = KTextView {
    withId(R.id.button_theme_black)
    isInstanceOf(MaterialButton::class.java)
    withParent {
        isInstanceOf(LinearLayout::class.java)
    }
}

val matchSystemThemeSwitcher = KSwitch {
    withId(R.id.theme_chooser_match_system_theme_switch)
    withText(R.string.theme_chooser_dialog_match_system_theme_switch_label)
    isInstanceOf(MaterialSwitch::class.java)
    withParent { isInstanceOf(LinearLayout::class.java) }
}