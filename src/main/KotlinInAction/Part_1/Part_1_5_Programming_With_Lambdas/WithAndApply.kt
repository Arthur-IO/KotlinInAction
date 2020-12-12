package main.KotlinInAction.Part_1.Part_1_5_Programming_With_Lambdas

import java.lang.StringBuilder

// This file demonstrates the usage of 'with' and 'apply'

/**
 * To use 'with' we pass another object as a receiver to it
 * so that we can use that object as a reference within the
 * block of code
 *
 * Note: Extension functions are like lambdas with receivers
 */

fun main(args: Array<String>) {
    println(alphabet())
}

/**
 * A function that utilizes the 'with' function
 * The with function always returns the last line within the block
 */
fun alphabet(): String = with(StringBuilder()) {
    for (letter in 'A'..'Z')
        this.append(letter)

    this.append("Now I know the alphabet")
    this.toString()
}

/**
 * Apply always returns the receiver object
 */
fun alphabetWithApply(): String = StringBuilder().apply {
    for (letter in 'A'..'Z')
        this.append(letter)

    this.append("Now I know the alphabet")
}.toString()

/**
 * buildString is a standard Kotlin Library lambda
 */
fun alphabetSimplified(): String = buildString {
    for (letter in 'A'..'Z')
        this.append(letter)

    this.append("Now I know the alphabet")
}