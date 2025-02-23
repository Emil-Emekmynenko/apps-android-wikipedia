package org.wikipedia.homeworks.homework08

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class OnboardingPagerItem(matcher: Matcher<View>) : KViewPagerItem<OnboardingPagerItem>(matcher) {

    val logo = KImageView(matcher){
        withId(R.id.imageViewCentered)
    }

    val title = KTextView(matcher){
        withId(R.id.primaryTextView)
    }

    val subtitle = KTextView(matcher){
        withId(R.id.secondaryTextView)
    }

    val languageList = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.languageList)
        },
        itemTypeBuilder = {
            itemType(::ParamsLanguageItem)
        }
    )
    val addLanguageButton = KButton(matcher){
        withId(R.id.addLanguageButton)
    }
}