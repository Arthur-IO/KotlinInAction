package main.KotlinInAction.Part_1.Part_1_2_KotlinBasics

// This file demonstrates the usage of while & for loops as well as implements the fizz-buzz game

fun main(args: Array<String>) {
    // for loop utilizing [oneToHundred] variable
    for(number in oneToHundred) {
        print("${playFizzBuzzGame(number)}, ")
        if(number % 25 == 0)
            println()
    }

    // for loop counting down from 100 using even numbers
    for(number in 100 downTo 1 step 2) {
        print("${playFizzBuzzGame(number)}, ")
        if(number % 20 == 0)
            println()
    }

    // for looping counting up from 0 until 101 ( 101 is not inclusive with the until keyword )
    for(number in 0 until 101) {
        print("${playFizzBuzzGame(number)}, ")
        if(number % 25 == 0)
            println()
    }

}

/**
 * A range of numbers 1 through 100
 *
 * Ranges are inclusive meaning the first
 * and last number will always be included
 */
val oneToHundred = 1..100

/**
 * An implementation of the fizz-buzz game.
 *
 * @return When the [number] is divisible by:
 *
 * 15 -> "FizzBuzz"
 *
 * 3 -> "Fizz"
 *
 * 5 -> "Buzz"
 *
 * else print the passed [number]
 */
fun playFizzBuzzGame(number: Int) = when {
    number % 15 == 0 -> "FizzBuzz"
    number % 3 == 0 -> "Fizz"
    number % 5 == 0 -> "Buzz"
    else -> "$number"
}