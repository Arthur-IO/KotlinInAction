package main.KotlinInAction.Part_1.Part_1_5_Programming_With_Lambdas

// This file demonstrates the usage of 'all', 'any', 'count' and 'find' functions

fun main(args: Array<String>) {

    val numbers = listOf<Any>(1, 2, 3, 4, 5, 6, 7, 8, 9, "One", "Two", "Three", "Four", "Five")

    // Checks if all the elements are numbers
    val allNumbers = numbers.all { it is Int }
    println("Are there only numbers: $allNumbers")

    // Checks if any elements are numbers
    val anyNumbers = numbers.any { it is Int }
    println("Are there any numbers: $anyNumbers")

    // Checks how many elements are Strings
    val countOfStrings = numbers.count { it is String }
    println("Number of strings: $countOfStrings")

    // Finds the first element that matches

    val findThree = numbers.find { it == "Three" }
    println("Looking for three...")
    println("Found: $findThree")

}