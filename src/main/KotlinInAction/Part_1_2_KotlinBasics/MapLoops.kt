package main.KotlinInAction.Part_1_2_KotlinBasics

import java.util.*

fun main(args: Array<String>) {
    iterateOverMap()
}

/**
 * A demonstration of looping through a map
 */
fun iterateOverMap() {
    // Create map
    val binaryReps = TreeMap<Char, String>()

    // Add Characters A to F into map
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    // Loop through our map
    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }
}