package org.wikipedia.homeworks.homework13

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.TopReadItem
import org.wikipedia.homeworks.homework10.OnboardingUiScreen
import org.wikipedia.main.MainActivity

/*
Домашнее задание №13. WebView

1. Задание выполняем в homeworks/homework13
2. Написать сценарий:
- Переход в произвольную статью
- Проскроллить до элемента с id "References"
- Проверяем текст в элементе с id "References" (это уникальный элемент с постоянным текстом в английской локали)
- Написать xpath до пятой ссылки в тексте как на первой картинке
- Нажать на этот элемент
- Описать экран для всплывающего окна
- Во всплывающем окне (вторая картинка) проверить на соответствие текст заголовка и номер в строке (5.)
- Кнопкой back закрыть всплывающее окно
- Найти вторую ссылку с CSS классом mw-redirect и нажать на неё
- Описать всплывающий экран и нажать на нём кнопку Read article
- Перейти по этой кнопке в новую статью
- Проскроллить до элемента с id "References"
 */

class WebViewTest : TestCase() {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun scenarioTestView() {
        run {
            step("Пропуск оннбординга") {
                OnboardingUiScreen.buttonSkip.click()
            }
            step("Переход в статью") {
                ExploreScreen.items.childWith<TopReadItem> {
                    withDescendant {
                        withText("Featured article")
                    }
                }.perform {
                    click()
                }
            }
            step("Скроллим до элемента с id References и проверяем текст References") {
                ArticleScreenView {
                    webView {
                        withElement(Locator.CSS_SELECTOR, "#References") {
                            scroll()
                            hasText("References")
                        }
                    }
                }
            }
            step("Клик по 5 ссылке References") {
                ArticleScreenView {
                    webView {
                        withElement(
                            Locator.XPATH,
                            "//*[@id='cite_ref-OBrien_5-0']/a"
                        ) {
                            Thread.sleep(3000)
                            scroll()
                            click()
                        }
                    }
                }
            }
            step("Проверить заголовок всплывающего окна") {
                ReferenceScreenView {
                    title.containsText("Reference")
                }
            }
                    step("Проверить id Reference") {
                        ReferenceScreenView {
                            popupItem.childAt<ReferencePopupItem>(0) {
                                referenceId.containsText("5")
                            }
                        }
                }
                step("Нажать кнопку Назад") {
                    device.uiDevice.pressBack()
                }
                step("Нажать на ссылку с CSS классом mw-redirect") {
                    ArticleScreenView {
                    webView {
                        withElement(Locator.XPATH, "(//a[@class='mw-redirect'])[2]") {
                            click()
                        }
                    }
                }
            }
            step("Нажать на кнопку Read article") {
                DialogViewScreen.buttonReadArticle.click()
            }
            step("Скроллим до элемента с id References и проверяем текст References") {
                ArticleScreenView {
                    webView {
                        withElement(Locator.CSS_SELECTOR, "#References") {
                            scroll()
                            hasText("References")
                        }
                    }
                }
            }
        }
    }
}