package main.KotlinBasics

/**
 * Some function that shows that [if] in Kotlin is much
 * different than the usage of [if] in Java. In Kotlin
 * the [if-expression] returns a value. Whereas in Java
 * it is a statement which does not return a value
 */
fun foo(): Int =
    if(true) {
        1
    } else {
        2
    }

/**
 * Some function that shows that [when] should actually
 * be replaced with [if] in the Kotlin language
 */
fun bar(): Int =
    when (true) {
        true -> 1
        else -> 2
    }