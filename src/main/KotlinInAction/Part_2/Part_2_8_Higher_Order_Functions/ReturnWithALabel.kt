package main.KotlinInAction.Part_2.Part_2_8_Higher_Order_Functions

// This file demonstrates the usage of returning with a label

fun main(args: Array<String>) {

    (1..10).forEach {
        if(it == 5) return@forEach // This returns out of the function
            else println(it)
    }
    println("This line is always called")
}