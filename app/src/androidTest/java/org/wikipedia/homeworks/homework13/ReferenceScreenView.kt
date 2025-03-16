package org.wikipedia.homeworks.homework13

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object ReferenceScreenView : KScreen<ReferenceScreenView>() {
    override val layoutId = null
    override val viewClass = null

    val title = KTextView {
        withId(R.id.reference_title_text)
    }

    val popupItem = KViewPager2(
        builder = {
            withId(R.id.reference_pager)
        },
        itemTypeBuilder = {
            itemType (::ReferencePopupItem)
        }
    )
}