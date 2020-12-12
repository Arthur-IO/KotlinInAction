package main.KotlinInAction.Part_1_5_Programming_With_Lambdas

// This file demonstrates the usage of lambdas with collections

fun main(args: Array<String>) {
    val listOfPeople = arrayListOf<Person>(Person("Arthur", 24), Person("Audrey", 24),
                                            Person("Alex", 19))

    // When the last parameter is a lambda you can use the curly braces outside of the parenthesis
    val names = listOfPeople.joinToString(", ", "(", ")") { it.name }

    // Specify the type [p] when the context is unclear otherwise [it] is acceptable
    val getOldest = listOfPeople.maxByOrNull { p: Person -> p.age }

    // Demonstration of multi-line statement
    val area = product(10, 20)
    println(area)

    printNamesWithPrefix(listOfPeople, "God")

    val getAge = Person::age
    print(getAge)
}

fun printAge(age: Int) {
    println(age)
}

data class Person(val name: String, val age: Int)


/**
 * Finds the oldest [Person] given the list of people
 */
fun findOldestPerson(listOfPeople: List<Person>) : Person? =
        listOfPeople.maxByOrNull { it.age } // Both of these work
        //listOfPeople.maxByOrNull(Person::age) // Both of these work

/**
 * A sum function using lambda expression
 */
val sum = { x: Int, y: Int -> x + y }

/**
 * Computes the product of two variables [x],[y]
 * with a multiple statement lambda
 */
val product = { x: Int, y: Int ->
                println("Computing a product for $x and $y")
                x * y
}

/**
 * Prints all the names of the given list with a prefix
 */
fun printNamesWithPrefix(listOfPeople: List<Person>, prefix: String) {
    listOfPeople.forEach {
        println("$prefix ${it.name}")
    }
}