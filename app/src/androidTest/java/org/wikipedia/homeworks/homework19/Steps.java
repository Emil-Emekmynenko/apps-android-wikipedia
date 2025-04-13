package org.wikipedia.homeworks.homework19;

import com.kaspersky.kaspresso.device.Device
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.check.CheckableActions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.actions.SwipeableActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.edit.EditableActions
import io.github.kakaocup.kakao.text.TextViewAssertions
import io.github.kakaocup.kakao.web.WebAssertions

class Steps(val testContext: TestContext<*>) {
    private fun execute(step: String, actions: (StepInfo) -> Unit) {
        testContext.step(step, actions)
    }

    operator fun invoke(function: Steps.() -> Unit) {
        function()
    }

    fun click(element: BaseActions, name: String) {
        execute("Нажимаем на элемент '$name'") {
            element.click()
        }

    }


    fun swipeUp(element: SwipeableActions, name: String) {
        execute("Свапаем вверх ") {
            element.swipeUp()
        }

    }

    fun disableNetwork() {
        execute("Выключили интеренет") {
            testContext.device.network.disable()
        }
    }

    fun setOrientationLeft() {
        execute("Повернули влево экран") {
            testContext.device.uiDevice.setOrientationLeft()
        }
    }

    fun setOrientationRight() {
        execute("Повернули вправо экран") {
            testContext.device.uiDevice.setOrientationRight()
        }
    }

    fun setOrientationNatural() {
        execute("Повернули  экран в дефолт") {
            testContext.device.uiDevice.setOrientationNatural()
        }
    }

    fun typeText(element: EditableActions, name: String, message: String) {
        execute("Теккст для'$name'") {
            element.typeText(message)
        }

    }

    fun hasText(element: TextViewAssertions, name: String, text: String) {
        execute("У элемента'$name' есть текст '$text'") {
            element.hasText(text)
        }

    }

    fun containsText(element: TextViewAssertions, name: String, text: String) {
        execute("У элемента'$name' есть текст '$text'") {
            element.containsText(text)
        }

    }

    fun hasAnyText(element: TextViewAssertions, name: String) {
        execute("У элемента'$name' есть текст ") {
            element.hasAnyText()
        }

    }

    fun sleep(time: Long) {
        execute("Зависли на '$time'") {
            Thread.sleep(time)
        }
    }

    fun setChecked(element: CheckableActions, name: String, state: Boolean) {
        execute("Переключатель'$name' в '$state'") {
            element.setChecked(state)
        }
    }

    fun enableNetwork() {
        execute("Включили интеренет") {
            testContext.device.network.enable()
        }
    }

    fun isVisible(element: BaseAssertions, name: String) {
        execute("Элемент виден '$name'") {
            element.isVisible()
        }
    }
    fun isDisplayed(element: BaseAssertions, name: String) {
        execute("Элемент виден '$name'") {
            element.isDisplayed()
        }

    }
    fun isClikable(element: BaseAssertions, name: String) {
        execute("Элемент виден '$name'") {
            element.isClickable()
        }

    }
}
