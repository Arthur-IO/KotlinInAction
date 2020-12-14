package main.KotlinInAction.Part_2.Part_2_8_Higher_Order_Functions

import com.sun.org.apache.xpath.internal.operations.Bool
import java.lang.StringBuilder
import java.util.*

// This file demonstrates how to call functions passed in as arguments

fun main(args: Array<String>) {

    // Calls the twoAndThree function with the given operation
    twoAndThree { a, b ->
        a * b * 3000
    }

    // Calls the filter function on the String and filters the letters that match the predicate
    println("KotlinIsCool".filter { it == 'i' })
    // Calls the crop function on the String and crops out the letters that match the predicate
    println("KotlinIsCool".crop { it == 'l' })


    println(transformation(System.currentTimeMillis()) {
        Date(it as Long).toString()
    })
    println(transformation(1) {
        it.toString() + " apple"
    })

}

/**
 * Takes in any value and applies a transformation to it
 */
fun transformation(
    aType: Any,
    transform: (Any) -> Any = { it.toString() }
): Any {

    return transform(aType)

}

/**
 * An implementation of an extension function on the String
 * type that takes in a predicate as its argument and crops
 * out all the [Char]acters that match the predicate
 */
fun String.crop(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for (ch in this) {
        if (!predicate(ch)) sb.append(ch)
    }
    return sb.toString()
}

/**
 * Reimplementing the filter example for a [String]
 */
fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for (index in 0 until length) {
        val element = get(index)
        if (predicate(element)) sb.append(element)
    }
    return sb.toString()
}

/**
 * A function that takes a function as an argument
 * and calls the passed function
 */
fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}