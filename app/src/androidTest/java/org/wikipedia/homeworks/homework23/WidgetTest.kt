package org.wikipedia.homeworks.homework23

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework08.onboarding.OnboardingScreens
import org.wikipedia.homeworks.homework19.steps
import org.wikipedia.homeworks.homework20.namedSteps
import org.wikipedia.main.MainActivity

class WidgetTest: TestCase() {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun testWidget() = run {
        namedSteps {
            click(OnboardingScreens.skipButton)
            ExploreScreenWithWidget.searchWidget {
                isVisible(voice)
                isVisible(searchText)
            }
            ExploreScreenWithWidget.topReadItemWidgetText {
                topReadWidget {
                    topReadList(0) {
                        click(cardImage)
                    }
                }
            }
            pressBack(device)
            ExploreScreenWithWidget.topReadItemWidgetText {
                topReadWidget {
                    topReadList(1) {
                        isVisible(graph)
                        isVisible(rank)
                    }
                }
            }
        }
    }
}