package org.wikipedia.homeworks.homework10

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class OnboardingUiAutomatorTest : TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)
    val onboardingUiScreen = OnboardingUiScreen
    @Test
    fun checkElementsOnboardingFirstScreen() {
        run {
            onboardingUiScreen {
                step("Видимость картики") {
                    image.isDisplayed()
                }

                step("Отображение верного заголовка") {
                    title {
                        isDisplayed()
                        containsText("The Free Encyclopedia")
                    }
                }

                step("Отображение верного описания сабтайтла") {
                    subtitle {
                        isDisplayed()
                        hasText("We’ve found the following on your device:")
                    }
                }

                step("Отображение кнопки добавления языка") {
                    buttonAddLanguage {
                        isDisplayed()
                        hasText("Add or edit languages")
                    }
                }

                step("Отображение кнопки Skip") {
                    buttonSkip {
                        isDisplayed()
                        hasText("Skip")
                    }
                }

                step("Отображение кнопки Continue") {
                    buttonContinue {
                        isDisplayed()
                        hasText("Continue")
                    }
                }
            }
        }
    }
    private val countSwipes = 4

    @Test
    fun checkButtonGetStarted() {
            run {
                onboardingUiScreen {
                        step("Скролл элемента 3 раза") {
                            repeat(countSwipes) {
                                scrollElement.swipeLeft()
                            }
                    }
                        step("Отображение кнопки Get Started"){
                            buttonGetStarted {
                                isDisplayed()
                                hasText("Get started")
                            }
                        }
                        step("Кнопка пропуска не отображается") {
                            buttonSkip.isNotDisplayed()
                        }
                    }
                }
            }


    @Test
    fun checkElementsOnboardingSecondScreen(){
        run {
            onboardingUiScreen {
                step("Нажатие на кнопку Continue") {
                        buttonContinue.click()
                }
                step("Отображение кнопки Continue") {
                    buttonContinue {
                        isDisplayed()
                        hasText("Continue")
                    }
                }

                step("Видимость картики второго экрана онбординга") {
                    image.isDisplayed()
                }

                step("Отображение верного заголовка второго экрана онбординга") {
                    title {
                        isDisplayed()
                        containsText("New ways to explore")
                    }
                }

                step("Отображение верного описания сабтайтла второго экрана онбординга") {
                    subtitle {
                        isDisplayed()
                        containsText("Dive down the Wikipedia rabbit hole")
                    }
                }
            }
        }
    }
    @Test
    fun checkElementsOnboardingThreeScreen(){
        run {
            onboardingUiScreen {
                step("Скролл элемента 2 раза") {
                    repeat(countSwipes - 1) {
                        scrollElement.swipeLeft()
                    }
                }
                step("Отображение кнопки Continue") {
                    buttonContinue {
                        isDisplayed()
                        hasText("Continue")
                    }
                }

                step("Видимость картики третьего экрана онбординга") {
                    image.isDisplayed()
                }

                step("Отображение верного заголовка третьего экрана онбординга") {
                    title {
                        isDisplayed()
                        hasText("Reading lists with sync")
                    }
                }

                step("Отображение верного описания сабтайтла третьего экрана онбординга") {
                    subtitle {
                        isDisplayed()
                        containsText("You can make reading lists from articles")
                    }
                }
            }
        }
    }
}