package main.KotlinInAction.Part_1.Part_1_4_Classes_Objects_And_Interfaces

// This file demonstrates the usage of 'open', 'final' and 'abstract' keywords.

fun main(args: Array<String>) {
    val normalButton = ColorButton()
    normalButton.displayColor()
    normalButton.animate()

    val redButton = RedButton()
    redButton.displayColor()
    redButton.animate()

    val candyBar = TwixBar("Twix Chocolate Bar")
    candyBar.displayCalories()
}

/**
 * An 'open' class which can be inherited by other classes
 */
open class ColorButton(var color: String = "transparent") {

    // A 'closed' function by default
    fun displayColor() = println("I am ${color}")

    // An 'open' function that can be overriden
    open fun animate() = println("I'm an open function that can be overriden")

}

/**
 * An implementation of a [ColorButton] that demonstrates how an inherited
 * function can be overriden
 */
class RedButton(color: String = "red") : ColorButton(color) {

    /*
     * A function that is overriding it's inherited class' function and telling the compiler
     * that it does not want any sub-class that inherits this function to be able to override it
     */
    final override fun animate() = println("I'm inheriting [ColorButton] and overriding the animate() function")

}

/**
 * An 'abstract' class that cannot be instantiated directly
 */
abstract class CandyBar(val candyName: String) {

    abstract fun calories(): Int

    open fun servingSize() = 1

    fun displayCalories() = println("${candyName} suggests a serving size of ${servingSize()} which has a total of ${calories() * servingSize()} calories")

}

/**
 * An implementation of the abstract class [CandyBar]
 */
class TwixBar(candyName: String) : CandyBar(candyName) {

    override fun calories(): Int = 100

}