package org.wikipedia.homeworks.homework13

import android.view.View
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class ReferencePopupItem(matcher: Matcher<View>) : KViewPagerItem<ReferencePopupItem>(matcher) {

    val text = KTextView{
        withId(R.id.reference_text)
    }

    val referenceId = KTextView {
        withId(R.id.reference_id)
    }

}