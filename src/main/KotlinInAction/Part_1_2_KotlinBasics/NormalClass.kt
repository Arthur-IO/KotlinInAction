package main.KotlinInAction.Part_1_2_KotlinBasics

fun main(args: Array<String>) {
    val aNormalClass = NormalClass("A normal class", 52)
    println(aNormalClass.parameter1)
    println(aNormalClass.parameter2)

    aNormalClass.parameter2 = 42
    println(aNormalClass.parameter2)

    aNormalClass.foo()
}

/**
 * This class demonstrates the usage of a normal class in Kotlin
 */
class NormalClass(
    /**
     * A [read-only] property using the [val] keyword
     *
     * Read-only properties only have a [getter] as they are
     * read-only
     */
    val parameter1: String,
    /**
     * A [writable] property using the [var] keyword
     *
     * Writable properties have both a [getter] and [setter]
     */
    var parameter2: Int
) {
    /**
     * Some function that displays the properties passed to this class
     */
    fun foo() {
        println("$parameter1 and $parameter2")
    }

}