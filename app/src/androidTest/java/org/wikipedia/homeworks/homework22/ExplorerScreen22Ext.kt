package org.wikipedia.homeworks.homework22

import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.AnnounceCardViewItem
import org.wikipedia.homeworks.homework07.ListCardItemView

import org.wikipedia.homeworks.homework20.getName
import org.wikipedia.homeworks.homework20.name


fun ExplorerScreen22.getSearchCard(): SearchCardViewItem{
    return ExplorerScreen22.items.findByID<SearchCardViewItem>(
        targetIndex = 1,
        targetID = R.id.voice_search_button,
        blockName = "Search Card",
        limiter = ExplorerScreen22.items.getSize()
    ).apply {
        name(ExplorerScreen22.items.getName().withParent("Блок поиска"))
    }
}
fun ExplorerScreen22.searchCard(function: SearchCardViewItem.()->Unit){
    getSearchCard().apply(function)
}