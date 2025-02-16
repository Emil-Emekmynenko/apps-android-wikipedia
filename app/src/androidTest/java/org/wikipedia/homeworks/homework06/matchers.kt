package org.wikipedia.homeworks.homework06

import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

enum class Color {
    RED,
    BLUE,
    GREEN,
    YELLOW,
    BLACK,
    WHITE
}
data class Shape(
    val sideLength: Float,
    val numberSides : Int,
    val color: Color
)

class CheckSideLengthInRangeMatcher (
    private val min: Double,
    private val max: Double
) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("длинна стороны входит в пределах между $min и $max")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.sideLength in min..min
    }
}

class CheckingEvenNumberOfSides : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("Число сторон фигуры чётное")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.numberSides % 2 == 0
    }
}

class CheckingColorOfShape(val checkColor : Color): TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("Цвет фигуры совпадает с $checkColor ")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.color == checkColor
    }

}