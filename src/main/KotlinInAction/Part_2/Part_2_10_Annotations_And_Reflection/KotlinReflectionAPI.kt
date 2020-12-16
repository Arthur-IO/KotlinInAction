package main.KotlinInAction.Part_2.Part_2_10_Annotations_And_Reflection

import kotlin.reflect.*
import kotlin.reflect.full.functions
import kotlin.reflect.full.memberProperties

// This file demonstrates the usage of some simple Kotlin reflection tactics

fun main(args: Array<String>) {
    val animal = Animal("Betsy", 1, 0)

    val clazz: KClass<*> = animal.javaClass.kotlin
    println("Clazz simple name: ${clazz.simpleName}")
    clazz.memberProperties.forEach {
        println("clazz member property: ${it.name}")
    }

    val kFunction: KFunction<*> = ::foo
    kFunction.call(1)

    val kFunction2: KFunction2<Int, Int, Int> = ::bar
    println("Through kFunction2 Reflection: ${kFunction2.invoke(1, 2)}")

    val kProperty: KMutableProperty0<*> = ::counter
    kProperty.setter.call(12)
    println("Through kMutableProperty Reflection: ${kProperty.get()}")
}

var counter = 0

fun foo(x: Int) = println("Through foo() Reflection: $x")

fun bar(x: Int, y: Int): Int = x + y

data class Animal(
    val name: String,
    val age: Int,
    var medals: Int
)