package main.KotlinInAction.Part_2.Part_2_10_Annotations_And_Reflection

// This file demonstrates the usage of some simple annotations

fun main(args: Array<String>) {

    val cake = Cake()
    cake.eatIt()

}

fun <T> test(list: List<T>) {
    @Suppress("UNCHECKED_CAST")
    val strings = list as List<String>
}

class Cake {

    @Deprecated("Deprecated since version 1.0", ReplaceWith("eat()"))
    fun eatIt() {}

    fun eat() {}


}