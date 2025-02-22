package org.wikipedia.homeworks.homework07

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView

/*
1. Задание выполняем в homeworks/homework07
2. Продолжаем описывать экран Explore
3. Описать блок Customize, блок даты, блок Top Read (с вложенным ресайклером)
, блок In the news (с вложенным ресайклером).
4. Классы описаний блоков должны быть в отдельных файлах.
5. Описанные блоки добавить в типы блоков ресайклера экрана Explore.
 */

object ExploreScreen: KScreen<ExploreScreen>() {
    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val toolbarTitle = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }

    val items = KRecyclerView( // создаём элемент блока, для вызова
        builder = {
           withId(R.id.feed_view)
        },
        itemTypeBuilder = {
           itemType(::SearchCardViewItem)
           itemType(::AnnouncementCardViewItem)
           itemType(::DayHeaderCardViewItem)
           itemType(::TopReadItem)
           itemType(::InTheNewsItem)

        }
    )

}
