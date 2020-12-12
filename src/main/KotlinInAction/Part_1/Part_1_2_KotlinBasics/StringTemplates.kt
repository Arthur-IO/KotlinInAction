package main.KotlinInAction.Part_1.Part_1_2_KotlinBasics

// This file demonstrates the usage of String templates

/**
 * Setting our variable [name] to the value of the expression body
 * and printing using the String template
 */
fun main(args: Array<String>) {
    val name: String = if(args.size > 0) args[0] else "Kotlin"
    println("Hello, ${name}")
}