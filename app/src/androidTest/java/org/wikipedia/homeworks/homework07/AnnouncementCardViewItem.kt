package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.feed.announcement.AnnouncementCardView

class AnnouncementCardViewItem(matcher: Matcher<View>) : KRecyclerItem<AnnouncementCardView>(matcher) {

    val viewAnnouncementImage = KImageView(matcher){
        withId(R.id.view_announcement_header_image)
    }

    val textCustomizeExploreFeed = KTextView(matcher){
        withId(R.id.view_announcement_text)
    }

    val buttonCustomize = KButton(matcher){
        withId(R.id.view_announcement_action_positive)
    }

    val buttonGoIt = KButton(matcher){
        withId(R.id.view_announcement_action_negative)
    }
}