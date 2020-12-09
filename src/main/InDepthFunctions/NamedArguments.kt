package main.InDepthFunctions

// This file demonstrates the uses of named arguments within a function call

fun main() {
    // Using named attributes
    val jointString = list.joinToString(separator = ",", prefix = "(", postfix = ")")
    println(jointString)

    // Using only one attribute as the others have a default value
    val anotherJointString = list.joinToString()
    println(anotherJointString)
}