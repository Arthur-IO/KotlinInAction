package main.KotlinInAction.Part_1_2_KotlinBasics

// This file demonstrates my first successful usage of a top-level Kotlin function

fun main(args: Array<String>) {
    println(maxBlockBody(1, 2))
    println(maxExpressionBody(1, 2))
}

/**
 * A function that determines the maximum number
 * with the two given values [a] and [b] and returns it
 *
 * Comparing to Java this function utilizes ternary operators
 * with an [if-'expression'] rather than the [?] and [:] operators.
 *
 * Another thing to note is that the [return-type] is mentioned
 * after the [parameter-declaration] of the function
 */
fun maxBlockBody(a: Int, b: Int): Int {
    return if (a > b) a else b
}

/**
 * A demonstration of the above function, but having the
 * return value without the curly braces as the return value
 * is a [single-expression]
 */
fun maxExpressionBody(a: Int, b: Int): Int = if(a > b) a else b