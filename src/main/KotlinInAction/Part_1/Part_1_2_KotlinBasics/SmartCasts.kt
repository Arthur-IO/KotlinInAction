package main.KotlinInAction.Part_1.Part_1_2_KotlinBasics

/**
 * This interface is a demonstration of Kotlin interfaces
 */
interface Expression

/**
 * This class demonstrates a [Number] class implementing the [Expression] interface
 */
class Number(val value: Int) : Expression

/**
 * This class demonstrates a [Sum] class implementing the [Expression] interface
 */
class Sum(val left: Expression, val right: Expression) : Expression

/**
 * A top-level function that evaluates the passed [Expression]
 *
 * Here we demonstrate the difference between an explicit Java cast
 * vs. smart Kotlin cast
 */
fun eval(expr: Expression): Int {
    // Explicit cast (Java way)
    if(expr is Number) {
        val number: Number = expr as Number
        return number.value
    }
    // Smart cast (Kotlin Way)
    if(expr is Sum) {
        return eval(expr.left) + eval(expr.right)
    }
    throw IllegalArgumentException("Unknown expression")
}