package org.wikipedia.homeworks.homework13

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R

object ArticleScreenView: KScreen<ArticleScreenView>() {
    override val layoutId = null
    override val viewClass = null

    val webView = KWebView{
        withId(R.id.page_web_view)
    }

    val buttonGotIt = KButton {
        withId(R.id.buttonView)
    }
}