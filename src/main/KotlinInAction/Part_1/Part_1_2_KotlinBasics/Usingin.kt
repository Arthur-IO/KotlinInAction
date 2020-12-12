package main.KotlinInAction.Part_1.Part_1_2_KotlinBasics

// This file is a demonstration of the 'in' operator

/**
 * A top-level function that takes a random [Char] and recognizes
 * if it is a letter or a number. If it cannot recognize what type it is
 * an error is thrown
 */
fun recognizeChar(ch: Char) = when {
    isLetter(ch) -> "It's a letter"
    isNumber(ch) -> "It's a number"
    else -> throw IllegalArgumentException("$ch is not a valid character for this function")
}

/**
 * A top-level function that utilizes the [in] operator to determine
 * if the [ch] is a letter
 */
fun isLetter(ch: Char) = ch in 'a'..'z' || ch in 'A'..'Z'

/**
 * A top-level function that utilizes the [in] operator to determine
 * if the [ch] is a number
 */
fun isNumber(ch: Char) = ch in '0'..'9'