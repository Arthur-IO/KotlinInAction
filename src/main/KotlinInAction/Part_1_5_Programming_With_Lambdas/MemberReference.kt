package main.KotlinInAction.Part_1_5_Programming_With_Lambdas

// This file demonstrates the usage of member references

fun main(args: Array<String>) {

    // Stores a reference to the function isTenYearsOld
    val isTenYearsOld = Plant::isTenYearsOld

    // Uses the member reference as a predicate
    listOf(Plant(1), Plant(10)).filter(isTenYearsOld).forEach { println(it) }
}

data class Plant(val plantLife: Int) {

    fun isTenYearsOld() = plantLife >= 10

}