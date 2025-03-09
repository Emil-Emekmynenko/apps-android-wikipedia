package org.wikipedia.homeworks.homework11

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.uiautomator.UiSelector
import com.kaspersky.kaspresso.device.exploit.Exploit
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.InTheNewsItem
import org.wikipedia.homeworks.homework07.NewsCardViewItem
import org.wikipedia.homeworks.homework09.DecorViewItem
import org.wikipedia.homeworks.homework09.ListCardItem
import org.wikipedia.homeworks.homework09.WikiArticleCard
import org.wikipedia.homeworks.homework10.OnboardingUiScreen
import org.wikipedia.main.MainActivity
import java.util.Locale
import kotlin.jvm.Throws

/*
2. Написать тесты по уже имеющимся экранам, но с применением методов управления девайсом:
- поворот экрана и проверка ориентации через метод device.uiDevice.isNaturalOrientation
- выключение экрана, включение и проверка отображения элемента (любого)
- "свернуть" приложение кнопкой home и развернуть дважды нажав recent apps и проверить отображение элемента (любого)
- выключить сеть, перейти в статью и проверить отображение ошибки и кнопки Retry. Включить сеть и нажать Retry, проверить отображение заголовка (может работать некорректно, в этом случае забить на тест)
- поменять язык приложения и проверить текст какой-нибудь кнопки (не через ресурсы)
- проверить, что сейчас активна MainActivity.
- не забываем про восстановление состояния девайса через after.

 */
class DeviceTest: TestCase() {
    @get:Rule
    val mainActivity = ActivityScenarioRule(MainActivity::class.java)
    private val packageName = "org.wikipedia.alpha"

    @Test
    fun deviceTest() {
        run {
            device.uiDevice.wakeUp() // выводит девайс из спящего режима
            device.uiDevice.sleep() // гасит экран
            //device.uiDevice.click() // клик по координатам
            device.uiDevice.findObject(UiSelector().text("").index(23).packageName(packageName))
            // находит элемент по определённым селекторам, текст индекс, имя пакета и тд
            device.uiDevice.freezeRotation() // запрещает менять ориентацию девайса

        }
    }
    @Test
    fun checkNaturalOrientation() {
        before {
            device.exploit.setOrientation(Exploit.DeviceOrientation.Landscape)
        }.after {
            device.exploit.setOrientation(Exploit.DeviceOrientation.Portrait)
        }.run {
            device.uiDevice.isNaturalOrientation
        }
    }

    @Test
    fun checkIsVisibleElementAfterEnableScreen(){
        run {
            step("Перевод экрана в спящий режим") {
                device.uiDevice.sleep()
            }
            Thread.sleep(3000)
            step("Элемент addLanguage не отображается") {
                OnboardingUiScreen.buttonAddLanguage.isNotDisplayed()
            }
            step("Пробуждение экрана") {
                device.uiDevice.wakeUp()
            }
            Thread.sleep(3000)
            step("Отображение элемента addLanguage") {
                OnboardingUiScreen.buttonAddLanguage.isDisplayed()
            }
        }
    }

    @Test
    fun checkIsVisibleElementAfterCollapseScreen(){
        run {
            step("Свернуть приложение кнопкой home") {
                device.uiDevice.pressHome()
            }
            Thread.sleep(3000)

            step("Отображение элемента addLanguage") {
                OnboardingUiScreen.buttonAddLanguage.isNotDisplayed()
            }
            step("Развернуть приложение кнопкой recent apps") {
                repeat(2){
                    device.uiDevice.pressRecentApps()
                }
            }
            Thread.sleep(3000)
            step("Отображение элемента addLanguage") {
                OnboardingUiScreen.buttonAddLanguage.isDisplayed()
            }
        }
    }

    @Test
    fun checkIsVisibleElementAfterNetworkDisable(){
        before {
            OnboardingUiScreen.buttonSkip.click()
        }.after {
            device.network.toggleWiFi(true)
        }.run {
            val retryButton = device.uiDevice
                .findObject(UiSelector()
                    .text("Retry")
                    .packageName("org.wikipedia.alpha"))
            step("Проверка отображения экрана InTheNewsScreen"){
                ExploreScreen.items.childWith<InTheNewsItem> {
                    withDescendant {
                        withText("In the news")
                    }
                }.perform {
                    step("Пролистать до 2 слайда и нажать"){
                        newsCardViewRecycler.childAt<NewsCardViewItem>(2){
                            image.click()
                        }
                    }
                }
            }

            step("Выключить сеть") {
                device.network.toggleWiFi(false)
            }

            step("Нажать на статью"){
                DecorViewItem.cardRecycler.childAt<ListCardItem>(1){
                    imageCard.click()
                    WikiArticleCard.image.isNotDisplayed()
                }
            }

            step("Включить сеть") {
                device.network.toggleWiFi(true)
            }

            step("Проверка что элемент присутствует"){
                WikiArticleCard.image.isVisible()
            }

        }
    }

    @Test
    fun checkLanguageChange() {
        before {
        }.after { device.language.switchInApp(Locale.getDefault())
        }.run {
            step("Проверка языка") {
                step("Проверка немецкого языка") {
                    device.language.switchInApp(Locale.GERMANY)
                }
                step("Проверка кнопки Fortfahren") {
                    OnboardingUiScreen.buttonContinue.hasText("Fortfahren")
                }
            }
        }
    }

    @Test
    fun checkCurrentActivity() {
        before {
            OnboardingUiScreen.buttonSkip.click()
        }.after {
        }.run {
            step("проверка верное ли активити") {
                device.activities.isCurrent(MainActivity::class.java)
            }
        }
    }
}