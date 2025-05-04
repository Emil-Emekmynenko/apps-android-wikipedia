package org.wikipedia.homeworks.homework26

import androidx.test.espresso.Espresso.pressBack
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework19.steps
import org.wikipedia.homeworks.homework22.ExploreScreenNew
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity

class TestScenario: TestCase() {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun smartScenarioTest() {
        run {
            val checkSyncReading = CloseCustomizeYourToolBarSmartScenario(this)
            steps {
                checkSyncReading.init()
                click(OnboardingScreen.skipButton, "skip button")
                org.wikipedia.homeworks.homework20.ExploreScreenNew.topReadItem().perform {
                    click(topReadHeaderTitle,"ss") }
            }
        }
    }
}