package main.KotlinInAction.Part_2.Part_2_11_DSL_Construction

// This file demonstrates the usage of the 'invoke' convention

fun main(args: Array<String>) {

    val armenianGreeter = Greeter("Barev")
    armenianGreeter("Arthur")

}

/**
 * A class that can be called on as a function
 */
class Greeter(
    val greeting: String
) {
    operator fun invoke(name: String) {
        println("$greeting, $name")
    }
}