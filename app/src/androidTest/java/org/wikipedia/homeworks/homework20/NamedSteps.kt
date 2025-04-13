package org.wikipedia.homeworks.homework20

import android.widget.Checkable
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.check.CheckableActions
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.edit.EditableActions
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.homeworks.homework20.getName
import org.wikipedia.homeworks.homework20.setName
import org.wikipedia.homeworks.homework08.OnboardingScreen.skipButton

class NamedSteps(val testContext: TestContext<*>) {

    private fun execute(stepText: String, actions: (StepInfo) -> Unit) {
        testContext.step(stepText, actions)
    }


    operator fun invoke(function: NamedSteps.() -> Unit) {
        function()
    }


    fun click(item: BaseActions) {
        testContext.step("Нажимаем на элемент '${item.getName()}'") {
            item.click()
        }
    }

    fun isVisible(item: BaseAssertions) {
        testContext.step("проверяем видимость ${(item as BaseActions).getName()}") {
            item.isVisible()
        }
    }

    fun paused(millis: Long) {
        testContext.step("Сделать паузу в $millis") {
            Thread.sleep(millis)
        }
    }

//    - disableNetwork()
//    - enableNetwork()
//    - typeText() для EditableActions
//    - setChecked() для CheckableActions плюс передавать состояние которое нужно установить
//    - setOrientationLeft()
//    - setOrientationRight()
//    - setOrientationNatural()


    fun disableNetwork() {
        testContext.step("Disabling Network") {
            testContext.device.network.toggleWiFi(false)
        }
    }

    fun enableNetwork() {
        testContext.step("Enabling Network") {
            testContext.device.network.toggleWiFi(true)
        }

    }

    fun typeText(item: EditableActions, text: String) {
        testContext.step("Typing text: '$text'") {
            item.replaceText(text)
        }
    }

    fun setChecked(item: CheckableActions, state: Boolean) {
        testContext.step("Setting checked status for ${(item as BaseActions).getName()} as $state") {
            item.setChecked(true)
        }
    }

    fun setOrientationLeft() {
        testContext.step("Setting orientation to the left") {
            testContext.device.uiDevice.setOrientationLeft()
        }
    }

    fun setOrientationRight() {
        testContext.step("Setting orientation to the right") {
            testContext.device.uiDevice.setOrientationRight()
        }
    }

    fun setOrientationNatural() {
        testContext.step("Setting natural orientation") {
            testContext.device.uiDevice.setOrientationNatural()
        }
    }

//    - hasText()
//    - hasAnyText()
//    - containsText()
//    - isChecked()
//    - isNotChecked()
//    - isDisplayed()

    fun hasText(item: TextViewAssertions, text: String) {
        testContext.step("Check if ${(item as BaseActions).getName()} has text as follows: $text") {
            item.hasText(text)
        }
    }

    fun hasAnyText(item: TextViewAssertions, text: String) {
        testContext.step("Check if ${(item as BaseActions).getName()} contains any text ") {
            item.hasAnyText()
        }
    }

    fun containsText(item: TextViewAssertions, text: String) {
        testContext.step("Check if ${(item as BaseActions).getName()} contains text as follows: $text") {
            item.containsText(text)
        }
    }

    fun isChecked(item: CheckableAssertions, name: String) {
        testContext.step("Check if ${(item as BaseActions).getName()} is checked") {
            item.isChecked()
        }
    }

    fun isNotChecked(item: CheckableAssertions, name: String) {
        testContext.step("Check if ${(item as BaseActions).getName()} is not checked :) ") {
            item.isNotChecked()
        }
    }

    fun isDisplayed(item: BaseAssertions, name: String) {
        testContext.step("Check if ${(item as BaseActions).getName()} is displayed ") {
            item.isDisplayed()
        }
    }

}