package org.wikipedia.homeworks.homework10

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.scroll.UiScrollView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen
import org.wikipedia.R

object OnboardingUiScreen: UiScreen<OnboardingUiScreen>() {
    override val packageName: String = "org.wikipedia.alpha"

    val scrollElement = UiScrollView {
        withId(this@OnboardingUiScreen.packageName,"scrollViewContainer")
    }

    val image = UiView{
        withId(this@OnboardingUiScreen.packageName,"imageViewCentered")
    }

    val title = UiTextView {
        withId(this@OnboardingUiScreen.packageName,"primaryTextView")
    }

    val subtitle = UiTextView {
        withId(this@OnboardingUiScreen.packageName, "secondaryTextView")
    }

    val buttonAddLanguage = UiButton {
        withId(this@OnboardingUiScreen.packageName,"addLanguageButton")
    }

    val buttonSkip = UiButton {
        withId(this@OnboardingUiScreen.packageName,"fragment_onboarding_skip_button")
    }

    val buttonContinue = UiButton {
        withId(this@OnboardingUiScreen.packageName,"fragment_onboarding_forward_button")
    }

    val buttonGetStarted = UiButton {
        withId(this@OnboardingUiScreen.packageName,"fragment_onboarding_done_button")
    }


}