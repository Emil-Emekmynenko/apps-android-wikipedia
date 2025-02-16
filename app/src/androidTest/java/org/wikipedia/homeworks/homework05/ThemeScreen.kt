package org.wikipedia.homeworks.homework05


import android.widget.LinearLayout
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.views.DiscreteSeekBar

val buttonThemeBar = KTextView {
    withSibling { R.id.page_actions_tab_layout }
    withText("Theme")

}

val textSettingsCategory1 = KTextView {
    withId(R.id.textSettingsCategory)
    withText(R.string.theme_category_reading)
}

val placeholder = KTextView {
    withId(R.id.text_size_percent)
}

val buttonDecreaseTextSize = KTextView {
    withId(R.id.buttonDecreaseTextSize)
    withParent {
        isInstanceOf(LinearLayout::class.java)
    }
}

val seekBar = KSeekBar {
    withId(R.id.text_size_seek_bar)
    isInstanceOf(DiscreteSeekBar::class.java)
}

val buttonIncreaseTextSize = KTextView {
    withId(R.id.buttonIncreaseTextSize)
    withParent {
        isInstanceOf(LinearLayout::class.java)
    }
}

val buttonSansSerif = KView {
    withId(R.id.button_font_family_sans_serif)
    withText(R.string.font_family_sans_serif)
}
val buttonSerif = KView {
    withId(R.id.button_font_family_serif)
    withText(R.string.font_family_serif)
}

val textThemeChooserReading = KTextView { //текст
    withId(R.id.theme_chooser_reading_focus_mode_description)
}

val textThemeChooserReadingFocusSwitch = KImageView { //свитчер
    withId(R.id.theme_chooser_reading_focus_mode_switch)
}

val buttonThemeLight = KTextView {
    withId(R.id.button_theme_light)
}

val buttonThemeSepia = KTextView {
    withId(R.id.button_theme_sepia)
}

val buttonThemeDark = KTextView {
    withId(R.id.button_theme_dark)
}

val buttonThemeBlack = KTextView {
    withId(R.id.button_theme_black)
}

val switchMatchSystem = KImageView { //свитчер
    withId(R.id.theme_chooser_match_system_theme_switch)
}

val chooserDarkMode = KTextView { //свитчер
    withId(R.id.theme_chooser_dark_mode_dim_images_switch)
}
