package main.KotlinInAction.Part_2.Part_2_9_Generics

import main.KotlinInAction.Part_1.Part_1_3_Defining_And_Calling_Function.list

// This file demonstrates the usage of co-variance in generics

fun main(args: Array<String>) {

    val cats = Herd<Cat>()

    cats.addAll(
        listOf(
            Cat(), Cat(), Cat(), Cat(), Cat(), Cat()
        )
    )

    feedAll(cats)

}

abstract class Animal {
    abstract fun feed()
}

/**
 * Type parameter marked as 'out' to allow a function parameter
 * to accept all the sub-types of this classes type parameters
 *
 * For example: Animal has sub-types: Cat, Cow
 * In order to pass herd<Cat> or herd<Cow> to a function
 * that expects the parameter herd: Herd<Animal> we must
 * mark the type parameter with the 'out' keyword
 *
 * Note: 'out' should only be used when the methods using the type
 * only have 'out' positions (or that their return value is of type T)
 */
class Herd<T: Animal>(private val list: MutableList<T> = mutableListOf<T>()): MutableList<T> by list {


}

/**
 * An implementation of [Animal]
 */
class Cat: Animal() {

    override fun feed() {
        println("I ate a fish")
    }

}

/**
 * An implementaiton of [Animal]
 */
class Cow: Animal() {

    override fun feed() {
        println("I ate some grass")
    }

}

/**
 * A function that accepts a parameter of Herd<Animal>
 */
fun <T: Animal >feedAll(animals: Herd<T>) {
    animals.forEach { it.feed() }
}

fun <T> copyData(source: MutableList<out T>,
                 destination: MutableList<T>) {
    for (item in source) {
        destination.add(item)
    }
}