package org.wikipedia.homeworks.homework09

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

object DecorViewItem : KScreen<DecorViewItem>() {

    override val layoutId = null
    override val viewClass = null

    val imageNews = KImageView {
        withId(R.id.header_image_view)
    }

    val subTitle = KTextView {
        withId(R.id.story_text_view)
    }

    val cardRecycler = KRecyclerView (
        builder = {
            withId(R.id.news_story_items_recyclerview)
        },
        itemTypeBuilder = {
            itemType (::ListCardItem)
        }
    )

}