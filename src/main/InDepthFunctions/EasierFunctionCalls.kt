package main.InDepthFunctions

// This file demonstrates how easy function calls within Kotlin are

fun main() {
    // Create an empty int array
    val anArr : ArrayList<Int> = arrayListOf()

    // Add numbers 1 to 10 to array
    for (i in 1..10)
        anArr.add(i)

    // Create a joint string of the collection
    val jointString = joinToString(anArr, ", ", "(", ")")

    // Print its value
    println(jointString)
}

/**
 * A demonstration of how printing the list automatically the .toString method
 */
fun printList() {
    println(list)
}

/**
 * A function that can be called on an array to join the elements as a string
 * in a special way
 */
fun <T> joinToString(
    collection: Collection<T>,
    separator: String = " ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}