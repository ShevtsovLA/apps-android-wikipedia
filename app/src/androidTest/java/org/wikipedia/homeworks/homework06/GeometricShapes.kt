package org.wikipedia.homeworks.homework06

import org.hamcrest.Description
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher

enum class Color { RED, BLUE, GREEN, YELLOW, BLACK, WHITE }

data class Shape(val sideLength: Float, val numberOfSides: Int, val color: Color)

class SideLengthInRangeMatcher(
    private val min: Float,
    private val max: Float
) : TypeSafeMatcher<Shape>() {
    override fun matchesSafely(shape: Shape): Boolean {
        return shape.sideLength in min..max
    }

    override fun describeTo(description: Description) {
        description.appendText("side length should be between $min and $max")
    }
}

fun sideLengthInRange(min: Float, max: Float) = SideLengthInRangeMatcher(min, max)

class CornerCountMatcher(
    private val angleCount: Int
) : TypeSafeMatcher<Shape>() {
    override fun matchesSafely(shape: Shape): Boolean {
        val sides = shape.numberOfSides
        return if (sides >=3) {
            sides == angleCount
        } else {
            sides < 3
        }
    }

    override fun describeTo(description: Description) {
        description.appendText("number of corners should be equal to number of sides for shapes with 3+ sides, or 0 for lines")
    }
}

fun cornerCount(angleCount: Int) = CornerCountMatcher(angleCount)

class EvenSidesMatcher : TypeSafeMatcher<Shape>() {
    override fun matchesSafely(shape: Shape): Boolean {
        return shape.numberOfSides % 2 == 0
    }

    override fun describeTo(description: Description) {
        description.appendText("shape should have even number of sides")
    }
}

fun evenSides() = EvenSidesMatcher()

class ColorMatcher(
    private val color: Color
) : TypeSafeMatcher<Shape>() {
    override fun matchesSafely(shape: Shape): Boolean {
        return shape.color == color
    }

    override fun describeTo(description: Description) {
        description.appendText("color should be $color")
    }
}

fun hasColor(color: Color) = ColorMatcher(color)

class NoNegativeSideLengthMatcher : TypeSafeMatcher<Shape>() {
    override fun matchesSafely(shape: Shape): Boolean {
        return shape.sideLength >= 0
    }

    override fun describeTo(description: Description) {
        description.appendText("side length should be positive")
    }
}

fun noNegativeSideLength() = NoNegativeSideLengthMatcher()

class NoNegativeSideNumberMatcher : TypeSafeMatcher<Shape>() {
    override fun matchesSafely(shape: Shape): Boolean {
        return shape.numberOfSides >= 0
    }

    override fun describeTo(description: Description) {
        description.appendText("number of sides should be positive")
    }
}

fun noNegativeSideNumber() = NoNegativeSideNumberMatcher()

fun main() {
    val shapes = listOf(
        Shape(10f, 3, Color.RED),
        Shape(0.5f, 1, Color.YELLOW),
        Shape(-12f, 6, Color.RED),
        Shape(9f, 5, Color.YELLOW),
        Shape(6f, 10, Color.RED),
        Shape(25f, 12, Color.YELLOW),
        Shape(40f, 18, Color.RED)
    )

    val matchers = allOf(
        noNegativeSideNumber(),
        noNegativeSideLength(),
        sideLengthInRange(0.1f, 30f)
    )

    val result = shapes.filter { matchers.matches(it) }

    println(result)
}