package org.wikipedia.homeworks.homework06

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
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

// Проверка длины стороны в заданном диапазоне

class CheckSideLengthInRangeMatcher (
    private val min: Float,
    private val max: Float
) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("длинна стороны входит в пределах между $min и $max")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.sideLength in min..min
    }
}

// Проверка на чётное количество сторон.

class CheckingEvenNumberOfSides : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("Число сторон фигуры чётное")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.numberSides % 2 == 0
    }
}

// Проверка цвета фигуры.

class CheckingColorOfShape(private val checkColor : Color): TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("Цвет фигуры совпадает с $checkColor ")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.color == checkColor
    }

}

// Проверка на наличие отрицательной длины стороны (недопустимо).

class NegativeSideLength: TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("Недопустимо, чтобы количество было отрицательным")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.sideLength <= 0.1
    }
}

// Проверка на наличие отрицательного количества сторон (недопустимо)

class NegativeNumberOfSides: TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("Недопустимо, чтобы количество было отрицательным")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.numberSides <= 0
    }
}

// Проверка количества углов:

class NumberOfAngles: TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("Количество углов")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return if (item.numberSides >= 3) {
            true
        } else item.numberSides in 0..2
    }
}

class MatcherBuilder() {
    val listOfMatchers = mutableListOf<Matcher<Shape>>()
    operator fun invoke(function: MatcherBuilder.() -> Unit) {
        function()
    }

}

fun main() {
    val shapes = listOf(
        Shape(10f, 3, Color.RED),
        Shape(5f, 4, Color.BLUE),
        Shape(7f, 2, Color.GREEN),
        Shape(0.5f, 1, Color.YELLOW),
        Shape(-3f, 5, Color.BLACK),
        Shape(8f, -2, Color.WHITE),
        Shape(12f, 6, Color.RED),
        Shape(15f, 8, Color.BLUE),
        Shape(20f, 4, Color.GREEN),
        Shape(9f, 5, Color.YELLOW),
        Shape(2f, 3, Color.BLACK),
        Shape(11f, 7, Color.WHITE),
        Shape(6f, 10, Color.RED),
        Shape(3f, 2, Color.BLUE),
        Shape(4f, 1, Color.GREEN),
        Shape(25f, 12, Color.YELLOW),
        Shape(30f, 14, Color.BLACK),
        Shape(35f, 16, Color.WHITE),
        Shape(40f, 18, Color.RED),
        Shape(50f, 20, Color.BLUE)
    )
    val matchers = allOf(
        CheckSideLengthInRangeMatcher(1.0f,20.2f),
        CheckingColorOfShape(Color.BLUE),
        CheckingEvenNumberOfSides(),
        NegativeNumberOfSides(),
        NegativeSideLength(),
        NumberOfAngles()
    )

    val result = shapes.filter {matchers.matches(it)}

    println(result)
}


