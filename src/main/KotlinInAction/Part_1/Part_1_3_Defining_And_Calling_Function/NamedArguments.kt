package main.KotlinInAction.Part_1.Part_1_3_Defining_And_Calling_Function

// This file demonstrates the uses of named arguments within a function call

fun main() {
    // Using named attributes
    val jointString = list.joinToString(separator = ",", prefix = "(", postfix = ")")
    println(jointString)

    // Using only one attribute as the others have a default value
    val anotherJointString = list.joinToString()
    println(anotherJointString)
}