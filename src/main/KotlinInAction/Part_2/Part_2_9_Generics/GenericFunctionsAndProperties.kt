package main.KotlinInAction.Part_2.Part_2_9_Generics

// This file demonstrates the usage of generic functions and properties

fun main(args: Array<String>) {

    val alphabet = ('a'..'z').toList()
    println(alphabet.slice(3..20))

    val names = listOf("Arthur", "Audrey", "Alex", "Ashley", "John", "Jane", "Joshua")
    println(names.slice(2..5))

    println(names.middleElement)
    println(names.slice(2..6).middleElement)

}

/**
 * A generic function that slices a range of elements
 * from the list
 */
fun <T> List<T>.slice(indice: IntRange): List<T> {
    return this.subList(indice.first, indice.last)
}

/**
 * Retrieves the middle element from this list
 */
val <T> List<T>.middleElement: T
    get() = this[this.size / 2]