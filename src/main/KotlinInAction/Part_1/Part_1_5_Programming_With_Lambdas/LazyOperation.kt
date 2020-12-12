package main.KotlinInAction.Part_1.Part_1_5_Programming_With_Lambdas

// This file demonstrates the usage of 'lazy' operations and 'sequences'

/**
 * Note:
 * 1) Only use a [Sequence] when you are running a chain of operations on a very
 * large collection.
 *
 * 2) In a normal collection a chain of operations performs each operation on the whole
 * collection before moving onto the next operation. However, with [Sequence]s this does
 * not work the same exact way. In [Sequence]s each element going through the chain of operations
 * sequentially before moving onto the next element
 *
 * 3) Unlike 'eager' evaluations a 'lazy' evaluation does not need to go through every element
 * before finding the correct result. For example, when using 'find' as a 'lazy' evaluation
 * we can sometimes find the result we are looking for before we finish going through the
 * entire list
 *
 * 4) Stream vs. Sequence: Streams and Sequences are pretty much the same except Streams allow to
 * be run on multiple CPUs in parallel
 */

fun main(args: Array<String>) {

    val fruits = listOf("Apple", "Banana", "Apricot", "Plum", "Mango", "Peach")

    println(filterForCharWithSeq(fruits, 'A'))
    println(filterForCharWithSeq(fruits, 'B'))

}

/**
 * Filters a list by checking if the first letter of each element within the list
 * starts with the given [Char] argument
 */
fun filterForCharWithSeq(list: List<String>, ch: Char) = list.asSequence().filter { it.startsWith(ch) }.toList()