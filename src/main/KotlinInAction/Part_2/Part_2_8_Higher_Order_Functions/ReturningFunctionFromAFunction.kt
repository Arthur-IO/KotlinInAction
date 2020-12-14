package main.KotlinInAction.Part_2.Part_2_8_Higher_Order_Functions

import main.KotlinInAction.Part_1.Part_1_3_Defining_And_Calling_Function.list

// This file demonstrates the returning of a function from a function

fun main(args: Array<String>) {

    val order = Order(10)

    val expeditedCalc = getShippingCostCalculator(Delivery.EXPEDITED)
    println("The price to ship is : ${expeditedCalc(order)}")

    val chaalo = Dog("Chaalo", "Arthur")
    val max = Dog("Max", "Alex")

    val listOfDogs = listOf<Dog>(chaalo, max)

    // Example of creating a filter predicate
    val dogListFilters = DogListFilters()
    // Example of using when with the filter object
    with(dogListFilters) {
        prefix = "A"
        byOwnerName = true
        // Example of using a predicate to filter our dog list
        listOfDogs.filter(getPredicate()).forEach { println(it) }
    }

}

data class Dog(val name: String, val owner: String)

class DogListFilters {
    var prefix: String = ""
    var byOwnerName: Boolean = false

    fun getPredicate(): (Dog) -> Boolean {
        val startsWithPrefix = { dog: Dog ->
            if(byOwnerName) dog.owner.startsWith(prefix) else dog.name.startsWith(prefix)
        }
        return startsWithPrefix
    }

}

/**
 * The type of Delivery shipping
 */
enum class Delivery { STANDARD, EXPEDITED }

/**
 * Order with just the item count for the order
 */
class Order(val itemCount: Int)

/**
 * Calculates the shipping cost of the specified [Delivery]
 * @param delivery The [Delivery] type to calculate a cost with
 * @return A [Unit] that calculates the cost
 */
fun getShippingCostCalculator(
    delivery: Delivery
): (Order) -> Double {
    if (delivery == Delivery.EXPEDITED) {
        return { order -> 6 + 2.1 * order.itemCount }
    }
    return { order -> order.itemCount * 1.2 }
}