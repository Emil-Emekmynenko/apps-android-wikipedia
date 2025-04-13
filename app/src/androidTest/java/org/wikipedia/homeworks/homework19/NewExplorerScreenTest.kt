package org.wikipedia.homeworks.homework19

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework03.OnboardingScreen
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.ListCardItemView
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework07.TopReadCardItem
import org.wikipedia.homeworks.homework07.TopReadItem
import org.wikipedia.homeworks.homework13.steps
import org.wikipedia.main.MainActivity

class NewExploreScreenTests : TestCase(Kaspresso.Builder.withForcedAllureSupport ()) {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun simpleTest() {
        run {

            steps{
                isClikable(OnboardingScreen.skipButton,"Skipping button")
                click(OnboardingScreen.skipButton,"Skipping button")
                isDisplayed(ExploreScreen.title, "Toolbar")
                ExploreScreen.items.childAt<SearchCardViewItem>(0) {
                    isDisplayed(voiceIcon,"Microphon")
                }
                swipeUp(ExploreScreen.items, "swipe")

                ExploreScreen.items.childAt<TopReadItem>(4){
                    isDisplayed()

                    listCardListItem.childAt<TopReadCardItem>(1) {
                        isDisplayed(image, "Картинка")


                    }
                }
            }
        }
    }
}