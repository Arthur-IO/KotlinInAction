package main.KotlinInAction.Part_1_2_KotlinBasics

import com.sun.javaws.exceptions.InvalidArgumentException
import java.lang.IllegalArgumentException

// This file is a demonstration of throwing an exception within Kotlin

fun main() {
    val aNumber = 1004

    val percentage =
        if (aNumber in 1..100)
            aNumber
        else
            throw IllegalArgumentException("A percentage value must be between 1 and 100. $aNumber")

    val aString = "Hi"

    // Try is also an expression so we can use an expression body
    val percentageTry = try {
        aString
    } catch (e: InvalidArgumentException) {
        e.printStackTrace()
    } finally {
        0
    }

}