package main.KotlinInAction.Part_1.Part_1_5_Programming_With_Lambdas

// This file demonstrates the creating of sequences

fun main(args: Array<String>) {

    // Generates a sequence
    val naturalNumbers = generateSequence(0) { it + 1 }
    // Keeps the sequence going as long as the predicate is true
    val numbersTo1000 = naturalNumbers.takeWhile { it <= 1000 }
    // Lazily loads the call later on
    println(numbersTo1000.sum())

}