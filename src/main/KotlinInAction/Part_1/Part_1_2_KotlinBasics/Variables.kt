package main.KotlinInAction.Part_1.Part_1_2_KotlinBasics

// This file demonstrates the declaration of variables

// Usage of type inference
val name = "Arthur"
val age = 24
val statement = "Hello, my name is ${name}. I am ${age} years old."

fun main(args: Array<String>) {
    println(statement)
}

// Usage of type declaration
val drinkingAge: Int = 21
val fullName: String = "Arthur Behesnilian"

// Usage of mutable and immutable variables
val immutableVariable: Int = 1
var mutableVariable: Int = 1

// Usage of a immutable variable but used object is mutable
val colorArrayList = arrayListOf("Red", "Green", "Blue")
fun addColorToArray(color: String) = colorArrayList.add(color)

