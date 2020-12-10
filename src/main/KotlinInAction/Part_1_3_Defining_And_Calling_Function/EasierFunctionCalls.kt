package main.KotlinInAction.Part_1_3_Defining_And_Calling_Function

// This file demonstrates how easy function calls within Kotlin are

fun main() {
    // Create an empty int array
    val anArr : ArrayList<Int> = arrayListOf()

    // Add numbers 1 to 10 to array
    for (i in 1..10)
        anArr.add(i)

    // Create a joint string of the collection
    val jointString = anArr.joinToString(", ", "(", ")")

    // Print its value
    println(jointString)
}

/**
 * A demonstration of how printing the list automatically the .toString method
 */
fun printList() {
    println(list)
}