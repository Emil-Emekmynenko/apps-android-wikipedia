package org.wikipedia.homeworks.homework22

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.AnnounceCardViewItem
import org.wikipedia.homeworks.homework07.DayHeaderViewItem
import org.wikipedia.homeworks.homework07.FeaturedArticleCardViewItem
import org.wikipedia.homeworks.homework07.ListCardItemView
import org.wikipedia.homeworks.homework07.NewsCardViewItem
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework07.TopReaderCardViewIteam
import org.wikipedia.homeworks.homework20.NamedKScreen
import org.wikipedia.homeworks.homework20.ExplorerScreenNew
import org.wikipedia.homeworks.homework20.getName
import org.wikipedia.homeworks.homework20.invokeAtIndex
import org.wikipedia.homeworks.homework20.name

object ExplorerScreen22: NamedKScreen<ExplorerScreenNew>() {
    override val screenName = "Explore Screen"
    override val layoutId = null
    override val viewClass = null
    val toolbarTitle: KImageView by lazy {
        KImageView { withId(R.id.main_toolbar_wordmark) }.name(ExplorerScreenNew.withParent("Заголовок"))
    }

    val items  by lazy  {
        KRecyclerView(
            builder = { withId(R.id.feed_view) },
            itemTypeBuilder = {
                itemType(::FeaturedArticleCardViewItem)
                itemType(::SearchCardViewItem)
                itemType(::AnnounceCardViewItem)
                itemType(::DayHeaderViewItem)
                itemType(::TopReaderCardViewIteam)
                itemType(::NewsCardViewItem)
            }
        ).name(ExplorerScreenNew.withParent("Список блоков"))}

    fun topReaderCardViewItem(index: Int, function: TopReaderCardViewIteam.()->Unit){
        items.invokeAtIndex(index,function)
    }
    fun getListItemView(index: Int, function: ListCardItemView.() -> Unit){
        items.invokeAtIndex(index,function)
    }
    fun announcementItemByID(targetIndex: Int, function: AnnounceCardViewItem.() -> Unit) {
        items.invokeByID(
            targetIndex = targetIndex,
            targetID = R.id.view_announcement_text,
            blockName = "Announcement Card",
            limiter = (4 * targetIndex).coerceAtLeast(5),
            function = function
        )
    }

    fun searchCardViewItembyID(targetIndex: Int, function: SearchCardViewItem.() -> Unit) {
        items.invokeByID(
            targetIndex = targetIndex,
            targetID = R.id.view_announcement_text,
            blockName = "Announcement Card",
            limiter = (4 * targetIndex).coerceAtLeast(5),
            function = function
        )
    }

    fun topReaderCardViewItem(): TopReaderCardViewIteam {
        return items.childWith<TopReaderCardViewIteam> {
            withDescendant {
                withText("Top read")
            }
        }.name(items.getName().withParent("Top read"))
    }

}