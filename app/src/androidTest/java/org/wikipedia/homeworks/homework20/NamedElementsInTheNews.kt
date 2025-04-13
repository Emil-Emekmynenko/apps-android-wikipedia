package org.wikipedia.homeworks.homework20

import NamedSteps
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework19.Steps
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework09.InTheNewsViewItem
import org.wikipedia.homeworks.homework09.NewsCardViewItem
import org.wikipedia.homeworks.homework09.NewsScreen
import org.wikipedia.homeworks.homework09.NewsStoryItemView
import org.wikipedia.homeworks.homework09.WikiArticleCardView
import org.wikipedia.main.MainActivity


class NamedElementsInTheNews :
    TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkNamedElementsInTheNews() {
        run {
            val steps = NamedSteps(this)
            steps {
                click(OnboardingScreen.skipButton)
                isVisible(ExploreScreenNew.searchIcon)
                click(ExploreScreenNew.customizeButton)
                ExploreScreenNew.topReadItemText().perform { hasAnyText(topReadHeaderTitle) }
                click(NamedTopReadItems.imageMenu)
            }
        }
    }
}
}