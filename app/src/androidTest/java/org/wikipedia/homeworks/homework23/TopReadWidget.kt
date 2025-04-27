package org.wikipedia.homeworks.homework23

import android.view.View
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.ListTopReadCardItem
import org.wikipedia.homeworks.homework23.ExploreScreenWithWidget.items
import org.wikipedia.homeworks.homework20.invokeAtIndex
import org.wikipedia.homeworks.homework20.name
import org.wikipedia.homeworks.homework20.withParent

class TopReadWidget: KWidget<TopReadWidget> {

    constructor(function: ViewBuilder.() -> Unit) : super(function)
    constructor(matcher: Matcher<View>, function: ViewBuilder.() -> Unit) : super(matcher, function)

    val cardHeader by lazy {
        KTextView(parent) {
            withId(R.id.view_card_header_title)
        }.name(withParent("Header"))
    }

    val languageCode by lazy {
        KTextView(parent) {
            withId(R.id.langCodeText)
        }.name(withParent("Language code"))
    }

    val cardHeaderMenu by lazy {
        KImageView(parent) {
            withId(R.id.view_list_card_header_menu)
        }.name(withParent("Header menu"))
    }

    val footerButton = KTextView(parent) {
        withId(R.id.footerActionButton)
    }

    val topReadList by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.view_list_card_list)
            },
            itemTypeBuilder = {
                itemType(::ListTopReadCardItem)
            }
        ).name(withParent("Список"))
    }

    fun topReadList(index: Int, function: ListTopReadCardItem.() -> Unit) {
        topReadList.invokeAtIndex(index, function)
    }


}