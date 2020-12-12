package main.KotlinInAction.Part_1.Part_1_4_Classes_Objects_And_Interfaces

// This file demonstrates the usage of data classes and class delegation

fun main(args: Array<String>) {
    val countingSet = CountingSet<Int>()
    for (i in 0 until 500) {
        countingSet.add(i)
    }
    countingSet.clear()
    println(countingSet.counter)
}

/**
 * A demonstration of using the 'by' keyword to delegate
 * the Mutable collection implementation to the innerSet
 */
class CountingSet<T>(
        val innerSet: MutableCollection<T> = HashSet<T>()
) : MutableCollection<T> by innerSet {

    /**
     * The total amount of times add was called
     */
    var counter: Int = 0
        private set

    override fun add(element: T): Boolean {
        counter++
        return innerSet.add(element)
    }

}

/**
 * A DATA CLASS
 *
 * A class that holds the general information of a [ClientData]
 * which also makes necessary checks to see if one [ClientData]s
 * information is equal to that of another one
 *
 * In a data class all the properties are accounted for in
 * the 'equals', 'hashcode' and 'toString' functions as well as
 * the 'copy' function which creates a 'deep-copy' of the instance
 */
data class ClientData(val name: String, val postalCode: Int)


/**
 * A NORMAL CLASS
 *
 * A class that holds the general information of a [Client]
 * which also makes necessary checks to see if one [Client]s
 * information is equal to that of another one
 */
class Client(val name: String, val postalCode: Int) {

    /**
     * Allows us to have more useful information for debugging or logging
     */
    override fun toString() = "Client[name=$name, postalCode=$postalCode]"

    /**
     * Allows us to determine whether this object is equal to another object
     * with the same exact data
     */
    override fun equals(other: Any?): Boolean {
        if(other == null || other !is Client)
            return false
        return name == other.name && postalCode == other.postalCode
    }

    /**
     * As a general rule of thumb when overriding an equals method
     * we should also override the hashCode method so that it avoids
     * conflict within other place. (I.E: HashSet)
     */
    override fun hashCode() = name.hashCode() * 31 + postalCode

}