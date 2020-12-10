@file:JvmName("Operations")

package main.KotlinInAction.Part_1_3_Defining_And_Calling_Function

// This file demonstrates the use of a top-level property in Kotlin

/**
 * A final suffix for our operation report
 */
const val OPERATION_COUNT_SUFFIX = " operations were performed."

/**
 * The total amount of times a certain operation was performed
 */
var operationCount = 0

/**
 * Increments the operation count by 1
 */
fun incrOperationCount() = operationCount++

/**
 * Reports the total amount of operations performed
 */
fun reportOperationCount() {
    println("Operation Report: $operationCount$OPERATION_COUNT_SUFFIX")
}
