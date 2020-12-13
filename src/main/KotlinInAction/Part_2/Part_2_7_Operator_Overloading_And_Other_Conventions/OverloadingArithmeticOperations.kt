package main.KotlinInAction.Part_2.Part_2_7_Operator_Overloading_And_Other_Conventions

// This file demonstrates the usage of arithmetic operation overloading

fun main(args: Array<String>) {

    val startPoint = Point(0, 0)
    val deltaPoint = Point(-5, 4)

    println(startPoint + deltaPoint)

}

/**
 * Overloading binary arithmetic operations can
 * also be done with extension functions
 */
operator fun Point.minus(other: Point): Point {
    return Point(this.x - other.x, this.y - other.y)
}

data class Point(val x: Int, val y: Int) {

    /**
     * To overload a binary arithmetic operations
     * you use the operator keyword before the function
     */
    operator fun plus(other: Point): Point {
        return Point(this.x + other.x, this.y + other.y)
    }

}