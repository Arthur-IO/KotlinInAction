package main.InDepthFunctions

// This file demonstrates the uses of named arguments within a function call

fun main() {
    // Using named attributes
    val jointString = joinToString(collection = list, separator = ",", prefix = "(", postfix = ")")
    println(jointString)

    // Using only one attribute as the others have a default value
    val anotherJointString = joinToString(collection = list)
    println(anotherJointString)
}