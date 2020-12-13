package main.KotlinInAction.Part_2.Part_2_7_Operator_Overloading_And_Other_Conventions

// This file demonstrates the overloading of compounded assignment operations (I.E val x += 4)

fun main(args: Array<String>) {
    val point = MutablePoint(0, 0)
    val delta = MutablePoint(1, -1)
    point += delta + delta
    println(point)

}

data class MutablePoint(var x: Int, var y: Int)

/**
 * Overloading the plus operator on our mutable point
 */
operator fun MutablePoint.plus(other: MutablePoint): MutablePoint {
    this.x += other.x
    this.y += other.y
    return this
}

/**
 * Overloading the += operator on our mutable point
 *
 * It is generally bad practice to use += and + at the same time
 */
operator fun MutablePoint.plusAssign(other: MutablePoint) {
    this + other
}