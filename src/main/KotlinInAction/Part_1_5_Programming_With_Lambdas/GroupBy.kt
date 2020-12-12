package main.KotlinInAction.Part_1_5_Programming_With_Lambdas

// This file demonstrates the usage of the 'groupBy' function

fun main(args: Array<String>) {
    // Create a list of people for data
    val list = listOf<Person>(Person("Arthur", 24), Person("Audrey", 24),
                                Person("Raffi", 55), Person("Alex", 19))

    // Group all the people by the age
    println(list.groupBy { it.age })

    // Create a list of strings for data
    val listOfStrings = listOf<String>("a", "b", "ab", "C", "DEf")

    // Group all the strings by the first letter
    println(listOfStrings.groupBy(String::first))

}