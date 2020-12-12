package main.KotlinInAction.Part_1.Part_1_4_Classes_Objects_And_Interfaces

// This file demonstrates properties accessing backing field in a 'setter' and 'getter

fun main(args: Array<String>) {
    val GOOG = Stock(345)
    while(true) {
        Thread.sleep(1000L)
        GOOG.updateStock()
    }
}

/**
 * A simple class that represents a person
 */
class Person(val name: String) {
    /**
     * A property which holds the address of a [Person]
     *
     * This field has a default value and a 'setter' that can
     * access it's backing field
     */
    var address: String = "undefined"
        set(value) {
            println("$name's address was modified.")
            field = value
        }
}

/**
 * A stock object that takes an initial stock value which
 * also appreciates in value as time passes
 */
class Stock(var initialValue: Int) {

    /**
     * The stocks initial age
     */
    val stockAge = System.currentTimeMillis()

    /**
     * The stocks initial value
     */
    var stockValue: Int = initialValue
        private set(value) {
            println("Stock grew in value by $${value - stockValue}")
            field = value
        }

    /**
     * Updates the stock value based on the time that has passed
     */
    fun updateStock() {
        val timePassed = System.currentTimeMillis() - stockAge
        stockValue *= (timePassed / 1000).toInt()
    }

}

