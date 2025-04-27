package org.wikipedia.homeworks.homework23

import androidx.test.espresso.matcher.ViewMatchers.withId
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.homeworks.homework20.NamedKScreen
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.TopReadCardItem
import org.wikipedia.homeworks.homework20.ExploreScreenNew
import org.wikipedia.homeworks.homework20.invokeAtDescendantText
import org.wikipedia.homeworks.homework20.invokeAtIndex
import org.wikipedia.homeworks.homework20.name

object ExploreScreenWithWidget : NamedKScreen<ExploreScreenWithWidget>() {
    override val screenName: String = "ExploreScreen"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val searchWidget by lazy {
        SearchWidget {
            withId(R.id.search_container)
        }.name(withParent("Виджет поиска"))
    }

    val items by lazy {
        KRecyclerView(
            builder = { withId(R.id.feed_view) },
            itemTypeBuilder = {
                itemType(::TopReadItemNew)
            }
        ).name(withParent("Список блоков"))
    }


    fun topReadItemWidget(index: Int, function: TopReadItemNew.() -> Unit) {
        items.invokeAtIndex(index, function)
    }

    fun topReadItemWidgetText(function: TopReadItemNew.() -> Unit) {
        items.invokeAtDescendantText("Top read", function)
    }
}