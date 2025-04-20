package org.wikipedia.homeworks.homework22

import org.wikipedia.homeworks.homework07.ListCardItemView
import org.wikipedia.homeworks.homework20.NewMegaOnboardingScreen
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework19.namedSteps
import org.wikipedia.homeworks.homework22.*
import org.wikipedia.main.MainActivity

class Explorer22Test : TestCase(Kaspresso.Builder.withForcedAllureSupport ()) {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun baseTest() {
        run {

            namedSteps{
                isClikable(NewMegaOnboardingScreen.skipButton)
                click(NewMegaOnboardingScreen.skipButton)
                isDisplayed(ExplorerScreen22.toolbarTitle)
                ExplorerScreen22.searchCard {
                    isDisplayed(voiceIcon)
                }
                swipeUp(ExplorerScreen22.items)

                ExplorerScreen22.topReaderCardViewItem(4){
                    isDisplayed(titleTopReader)
                    ExplorerScreen22.getListItemView(1) {
                        isDisplayed(image)
                    }
                }
            }
        }
    }
}