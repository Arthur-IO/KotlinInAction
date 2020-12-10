package main.KotlinInAction.Part_1_4_Classes_Objects_And_Interfaces

// This file demonstrates the usage of interfaces in Kotlin

fun main(args: Array<String>) {
    val myButton = Button()
    myButton.click()
    myButton.setFocus(true)
    myButton.foo()
    myButton.setFocus(false)
}

/**
 * A simple interface for a [Clickable] object
 */
interface Clickable {

    /**
     * An abstract function that represents a click that must
     * be implemented within the children of this interface
     */
    fun click()

    /**
     * A function that shows that the keyword 'default'
     * does not need to be used
     */
    fun foo() = println("I'm a default function")

}

/**
 * A simple interface for a [Focusable] object
 */
interface Focusable {

    /**
     * A simple 'default' function to demonstrate
     * what occurs when a child object needs to deal with
     * two implementations that have the same function name
     */
    fun foo() = println("I'm a focusable object")

    /**
     *  Sets focus to this [Focusable] object
     */
    fun setFocus(flag: Boolean) = println("I ${if (flag) "got" else "lost"} focus.")

}

/**
 * A [Button] implementation of a [Clickable] object
 */
class Button: Clickable, Focusable {

    // Demonstration of how override is used in Kotlin
    override fun click() {
        println("I'm a button")
    }

    /**
     * When specifying another default function with the same name
     * the keyword 'override' must be called in order to avoid
     * conflict with the parent of this class
     */
    override fun foo() {
        // Demonstration of the 'super' keyword to access the first parent
        super<Clickable>.foo()

        // Demonstration of the 'super' keyword to access the second parent
        super<Focusable>.foo()
    }

}