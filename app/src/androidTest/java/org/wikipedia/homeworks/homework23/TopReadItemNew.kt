package org.wikipedia.homeworks.homework23

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import org.hamcrest.Matcher
import org.hamcrest.Matchers.equalTo
import org.wikipedia.feed.topread.TopReadCardView
import org.wikipedia.homeworks.homework20.name
import org.wikipedia.homeworks.homework20.withParent

class TopReadItemNew(matcher: Matcher<View>): KRecyclerItem<TopReadItemNew>(matcher) {

    val topReadWidget by lazy {
        TopReadWidget(matcher) {
            withClassName(equalTo(TopReadCardView::class.java.name))
        }.name(withParent("Top Read block"))
    }
}