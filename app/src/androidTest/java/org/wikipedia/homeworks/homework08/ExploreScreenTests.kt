package org.wikipedia.homeworks.homework08

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class ExploreScreenTests: TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun simpleTest() {
        run {
            step("Пропуск онбординга"){
                OnboardingScreen08.skipButton.isClickable()
            }
        }
    }


    @Test
    fun addLanguageTest() {
        run {
            step("Кнопка добавить язык отображается") {
                OnboardingScreen08.slider.childAt<OnboardingPagerItem>(0) {
                    addLanguageButton.isDisplayed()
                }
            }
        }
    }


    @Test
    fun clickLanguageBtnTest() {
        run {
            step("Кнопка добавить язык нажимается") {
                OnboardingScreen08.slider.childAt<OnboardingPagerItem>(0) {
                    addLanguageButton.isClickable()
                }
            }
        }
    }

    @Test
    fun displayedLogoTest() {
        val pages = 3
        run {
            var currentPage = 0
            repeat(pages) {
                step("Отображение лого") {
                    OnboardingScreen08.slider.childAt<OnboardingPagerItem>(currentPage) {
                        logo.isDisplayed()
                    }
                }
                step("Страница после свайпа") {
                    OnboardingScreen08.forwardButton.click()
                }
                currentPage++
            }
        }
    }
}