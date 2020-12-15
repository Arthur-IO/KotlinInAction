package main.KotlinInAction.Part_2.Part_2_9_Generics

import java.util.*

// This file demonstrates the usage of reified types

fun main(args: Array<String>) {

    println(isA<String>("some string"))
    println(isA<Number>(1234))
    println(isA<Number>("1234"))

    println(listOf("hi", 1, 2, 3, "im arthur", "John doe").filterInstance<String>())

    val serviceImpl = loadService<SomeService>()

}

/**
 * Only inline functions can be reified when you use the keyword
 * reified along with the inline keyword the function is able
 * to check what the instance of the 'erased' type is.
 *
 * The way this works is that when the function is inlined the
 * function's code is inserted into the place where it was called.
 * The reified keyword will then allow you check the instance of that
 * type and will not be erased
 */
inline fun <reified T> isA(value: Any): Boolean = value is T

/**
 * Filters an iterable collection returning a List of the specified
 * type parameter
 */
inline fun <reified T> Iterable<*>.filterInstance(): List<T> {
    val destination = mutableListOf<T>()
    for (element in this) {
        if(element is T) {
            destination.add(element)
        }
    }
    return destination
}

class SomeService {}

/**
 * Uses the service loader by just expecting the type parameter
 */
inline fun <reified T> loadService(): ServiceLoader<T> = ServiceLoader.load(T::class.java)