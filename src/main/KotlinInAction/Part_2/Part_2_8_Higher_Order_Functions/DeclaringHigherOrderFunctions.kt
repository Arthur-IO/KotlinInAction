package main.KotlinInAction.Part_2.Part_2_8_Higher_Order_Functions

// This file demonstrates the declaration of higher-order functions

/**
 * A function type that takes two integers as
 * parameters and returns an integer]
 */
val sum: (Int, Int) -> Int = { x, y -> x + y }

/**
 * A function type that takes no arguments
 * and has a function as its return type
 */
val action: () -> Unit = { println(42) }

/**
 * A function that takes in a callback function as an
 * argument
 */
fun performRequest(
    url: String,
    callback: (code: Int, content: String) -> Unit
) {

}