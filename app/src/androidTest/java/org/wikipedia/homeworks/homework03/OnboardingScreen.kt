package org.wikipedia.homeworks.homework03

import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import org.wikipedia.views.AppTextView

val skipButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_skip_button",
    "onboarding_skip"
)

val continueButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_forward_button",
    "onboarding_skip"
)

val addLanguageButton = listOf(
    MaterialButton::class.java,
    "addLanguageButton",
    "onboarding_multilingual_add_language_text"
)


val tabLayoutButton = listOf(
    TabLayout::class.java,
    "view_onboarding_page_indicator"
)


val imageViewCentered = listOf(
    ImageView::class.java,
    "imageViewCentered"
)


val languagesList = listOf(
    RecyclerView::class.java,
    "languagesList"
)


val languagesListText = listOf(
    AppTextView::class.java,
    "option_label"
)


val startText = listOf(
    AppTextView::class.java,
    "secondaryTextView",
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
)


val startText2 = listOf(
    AppTextView::class.java,
    "primaryTextView",
    "Lorem ipsum"
)

