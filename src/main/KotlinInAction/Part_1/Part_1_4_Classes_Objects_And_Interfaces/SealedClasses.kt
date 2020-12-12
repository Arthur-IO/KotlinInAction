package main.KotlinInAction.Part_1.Part_1_4_Classes_Objects_And_Interfaces

// This file demonstrates the usage of a 'sealed' class by taking what we learned in [SmartCasts.kt]
// and applying it using 'sealed' classes

/**
 * A base class for our nested, sub-classes
 *
 * A sealed class is convenient as it allows us to know
 * all the possible sub-classes it could ever have. In other
 * areas of code when we use the [when] expression we do not
 * need to think about what will happen if we add new sub-classes
 * as the compiler will force us to deal with the new sub-class.
 * Thus, removing the requirement of the expression to maintain
 * or handle the default branch
 */
sealed class Expression {
    /**
     * A nested sub-class of [Expression]
     */
    class Num(val value: Int): Expression()

    /**
     * A nested sub-class of [Expression]
     */
    class Sum(val left: Expression, val right: Expression): Expression()
}

/**
 * A function that evaluates the passed [Expression]
 *
 * Since [Expression] is a sealed-class we know all the possible
 * nested sub-classes it has. Therefore, the when expression
 * knows all the types to check and does not need the default
 * branch
 */
fun eval(expression: Expression): Int = when(expression) {
        is Expression.Num -> expression.value
        is Expression.Sum -> eval(expression.left) + eval(expression.right)
    }