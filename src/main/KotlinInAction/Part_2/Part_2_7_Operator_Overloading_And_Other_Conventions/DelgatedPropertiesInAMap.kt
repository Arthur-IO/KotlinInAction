package main.KotlinInAction.Part_2.Part_2_7_Operator_Overloading_And_Other_Conventions

// This file demonstrates the usage of delegated properties in a map

fun main(args: Array<String>) {

    House.setAttribute("name", "Behesnilian")
    println(House.name)

}

object House {

    /**
     * Map that holds the attributes of a house
     */
    private val _attributes = hashMapOf<String, String>()

    /**
     * Assigns an attribute a value
     */
    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    /**
     * Accesses the map through delegation using the property name
     */
    val name: String by _attributes

}