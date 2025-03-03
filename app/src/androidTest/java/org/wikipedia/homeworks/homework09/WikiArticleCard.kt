package org.wikipedia.homeworks.homework09

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import org.wikipedia.R

object WikiArticleCard: KScreen<WikiArticleCard>() {
    override val layoutId = null
    override val viewClass = null

    val image = KView {
        withId(R.id.page_web_view)
    }
}