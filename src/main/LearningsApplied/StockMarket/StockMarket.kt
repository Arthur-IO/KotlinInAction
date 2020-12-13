package main.LearningsApplied.StockMarket

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import java.util.*
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

fun main(args: Array<String>) {
    // Create our random instance
    val random = Random()

    // Create some sample data
    val GOOG = Stock("GOOG", 1000)
    val APPL = Stock("APPL", 650)
    val AMZN = Stock("AMZN", 540)

    // Add our sample data
    StockMarket.addStock(GOOG, APPL, AMZN)

    // Observe stock market changes every 2.5 seconds
    while (true) {
        Thread.sleep(2500L)
        StockMarket.increaseStockValues((random.nextInt(100) * random.nextGaussian()).toInt())
    }
}

/**
 * Singleton instance of a [StockMarket] which keeps track of [Stock]s
 */
object StockMarket {

    /**
     * Our list of [Stock]s
     */
    private val stocks = arrayListOf<Stock>()

    /**
     * Adds a [Stock] to the list and assigns a change listener to each
     */
    fun addStock(vararg stockz: Stock) {
        stockz.forEach {
            it.apply {
                this.addChangeListener {
                    println("${this.name} value changed from ${it.oldValue} to ${it.newValue}")
                }
            }
            stocks.add(it)
        }
    }

    /**
     * Changes the stock value of all of the [Stock]s within the [StockMarket]
     */
    fun increaseStockValues(amount: Int) {
        stocks.forEach {
            it.stockValue += amount
        }
    }

}

/**
 * Represents a Stock
 * @param name The name of the Stock
 * @param stockValue The value of the stock that can change value
 */
class Stock(
    val name: String,
    stockValue: Int
): PropertyChangeAware() {

    /**
     * An observer that notifies our listeners about the changes of [stockValue]
     */
    private val stockValueObserver = {
        property: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(property.name, oldValue, newValue)
    }

    var stockValue: Int by Delegates.observable(stockValue, stockValueObserver)

}

/**
 * Support for the changing of properties
 */
open class PropertyChangeAware {

    val changeSupport = PropertyChangeSupport(this)

    fun addChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removeChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }

}