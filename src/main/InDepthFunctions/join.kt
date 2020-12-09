@file:JvmName("StringFunctions")

package main.InDepthFunctions

// This file demonstrates the use of the @file:JvmName annotation as well as a top-level function

/**
 * A function that can be called on an array to join the elements as a string
 * in a special way
 */
fun <T> Collection<T>.joinToString(
    separator: String = " ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}