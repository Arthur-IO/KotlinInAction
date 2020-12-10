package main.KotlinInAction.Part_1_2_KotlinBasics

fun main(args: Array<String>) {
    println(ColorWithProperties.RED.rgb())
}

/**
 * A top-level function that determines whether the [Color]
 * passed is my favorite color
 */
fun isMyFavoriteColor(color: Color) = when {
    (color == Color.RED) -> true
    else -> false
}

/**
 * A top-level function that determines the mixed color
 * of two [Color]s using an advanced version of the [when]
 * multi-line function
 */
fun mixColor(colorOne: Color, colorTwo: Color) = when(setOf(colorOne, colorTwo)) {
    setOf(Color.RED, Color.YELLOW) -> "ORANGE"
    setOf(Color.BLUE, Color.YELLOW) -> "GREEN"
    setOf(Color.BLUE, Color.RED) -> "PURPLE"
    setOf(Color.BLUE, Color.VIOLET) -> "INDIGO"
    else -> "A dirty mix"
}

/**
 * A top-level function that determines the warmth
 * of the [Color] using the [when] multi-line function
 * while using a expression-body
 */
fun getWarmth(color: Color) = when (color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.VIOLET, Color.INDIGO, Color.BLUE -> "cold"
}

/**
 * A top-level function that determines the mnemonic
 * match to the passed enum [Color] using the [when] multi-line function
 * while using a block-body
 */
fun getMnemonic(color: Color): String {
    return when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "of"
        Color.YELLOW -> "York"
        Color.GREEN -> "gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "in"
        Color.VIOLET -> "vain"
    }
}

/**
 * This class represents a simple-enum class
 */
enum class Color {
    RED, GREEN, BLUE, ORANGE, YELLOW, VIOLET, INDIGO
}

/**
 * This class represents a enum-class with properties
 * as well as a method for the enum class
 */
enum class ColorWithProperties (
    val r: Int,
    val g: Int,
    val b: Int
) {
    RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255); // Semi-colon is required if method is going to be declared

    fun rgb() = (r * 256 + g) * 256 + b
}