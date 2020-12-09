package main.InDepthFunctions

// This file demonstrates infix keyword modifier as well as destructuring in Kotlin

fun main(args: Array<String>) {
    // Demonstration of 'infix' function
    println(1 add 5)

    // Demonstration of 'destructuring declaration'
    val (name, age) = "arthur" to 1
    println("${name.capitalize()} is $age year${if (age > 1) "s" else ""} old")

}

/**
 * An implementation of an infix function in Kotlin
 */
infix fun Int.add(number: Int) = this + number