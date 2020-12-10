package main.KotlinInAction.Part_1_3_Defining_And_Calling_Function

// This file serves as a demonstration for various [Collection] implemenetations

/**
 * An implementation of [HashSet] in Kotlin
 */
val set = hashSetOf(1, 2, 3)

/**
 * An implementation of [List] in Kotlin
 */
val list = listOf(4, 5, 6)

/**
 * An implementation of [Map] in Kotlin
 */
val map = hashMapOf(1 to "one", 2 to "two", 3 to "three")

/**
 * An imeplementation of [ArrayList] in Kotlin
 */
val arr = arrayListOf("sixty", "eighty", "ninety")

/**
 * Finds the last element within an array
 */
fun lastElement(arr: ArrayList<String>) = arr.last()

/**
 * Finds the first element within an array
 */
fun firstElement(arr: ArrayList<String>) = arr.first()

/**
 * Finds the biggest number within a list
 */
fun biggestNumber(list: List<Int>) = list.max()

/**
 * Finds the smallest number within a list
 */
fun smallestNumber(list: List<Int>) = list.min()

