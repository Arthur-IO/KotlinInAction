package main.KotlinInAction.Part_1.Part_1_5_Programming_With_Lambdas

import java.util.*
import kotlin.collections.ArrayList

// This file demonstrates the usage of 'filter' and 'map' functions

fun main(args: Array<String>) {
    // Create our random number generator
    val random = Random()

    // Instantiate our array list
    val listOfPeople = arrayListOf<Person>()

    // Add random data to work with
    for (i in 0 until 100) {
        val p = Person("Person-$i", random.nextInt(100))
        listOfPeople.add(p)
    }

    // Collect a list of people ages twenty and below
    val peopleTwentyAndBelow = findAllAgeTwentyAndBelow(listOfPeople)
    val format = peopleTwentyAndBelow.joinToString(", ", "(", ")") {
        it.name
    }
    println(format)

    // Creates a new collection from our original collection containing only the names of the poeple
    val listOfNames = listOfPeople.map(Person::name)
    println(listOfNames.joinToString(", "))

    //findPeopleAgeThirtyAndPrint(listOfPeople)


    val aMap = mapOf(0 to "zero", 1 to "one", 2 to "two")
    println(aMap.filterKeys { it >= 1 })
    println(aMap.mapKeys { it })

}

/**
 * A demonstration of chaining lambdas together
 */
fun findPeopleAgeThirtyAndPrint(people: ArrayList<Person>) {
    people.filter { it.age >= 30 }.forEach { println("${it.name} - ${it.age}") }
}

fun findAllAgeTwentyAndBelow(list: ArrayList<Person>) = list.filter { it.age <= 20 }