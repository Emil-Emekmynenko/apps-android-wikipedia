package com.emil.org.emil.kotlincourse

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.MatcherAssert.assertThat
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
        return item.sideLength in min..max
    }
}

fun lengthRange(min: Float, max: Float): CheckSideLengthInRangeMatcher{
    return CheckSideLengthInRangeMatcher(min, max)
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
fun evenNumberOfSides(): CheckingEvenNumberOfSides{
    return CheckingEvenNumberOfSides()
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
fun colorOfShape(checkColor: Color): CheckingColorOfShape{
    return CheckingColorOfShape(checkColor)
}

// Проверка на наличие отрицательной длины стороны (недопустимо).

class NegativeSideLength: TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("Недопустимо, чтобы количество было отрицательным")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.sideLength >= 0
    }
}
fun negativeSideLength(): NegativeSideLength {
    return NegativeSideLength()
}

// Проверка на наличие отрицательного количества сторон (недопустимо)

class NegativeNumberOfSides: TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("Недопустимо, чтобы количество было отрицательным")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return item.numberSides >= 0
    }
}
fun negativeNumberOfSide(): NegativeNumberOfSides {
    return NegativeNumberOfSides()
}

// Проверка количества углов:

class NumberOfAngles(
    private val checkAngles: Int
): TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("Количество углов меньше трёх")
    }

    override fun matchesSafely(item: Shape): Boolean {
        return if (item.numberSides in 0..2) {
            checkAngles == 0
        } else if (item.numberSides >= 3) {
            item.numberSides == checkAngles
        } else throw IllegalArgumentException("Число углов отрицательное")
    }
}

fun numberOfAngles(checkAngles: Int): NumberOfAngles {
    return NumberOfAngles(checkAngles)
}

class MatcherBuilder() {
    val listOfMatchers = mutableListOf<Matcher<Shape>>()
    operator fun invoke(function: MatcherBuilder.() -> Unit) {
        function()
    }

}

fun main() {
//    val shape1 = Shape(100.0f, -6, Color.GREEN)
//    assertThat(shape1, lengthRange(99.0f, 101.0f))
//    assertThat(shape1, evenNumberOfSides())
//    assertThat(shape1, colorOfShape(Color.GREEN))
//    assertThat(shape1, negativeSideLength())
//    assertThat(shape1, negativeNumberOfSide())
//    assertThat(shape1, numberOfAngles(6))



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
    val filterMatchers = shapes.filter { item ->
        allOf(
            lengthRange(1f, 101f),
            evenNumberOfSides(),
            colorOfShape(Color.RED),
            negativeSideLength(),
            negativeNumberOfSide(),
            numberOfAngles(10)
        ).matches(item)
    }

    println(filterMatchers)
}


