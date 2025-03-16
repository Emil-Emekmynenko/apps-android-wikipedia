package org.wikipedia.homeworks.homework13

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object PopupBackgroundViewScreen: KScreen<PopupBackgroundViewScreen>() {
    override val layoutId = null
    override val viewClass = null

    val buttonGotIt = KButton {
        withId(R.id.buttonView)
    }
}