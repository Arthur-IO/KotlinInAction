package main.KotlinInAction.Part_2.Part_2_7_Operator_Overloading_And_Other_Conventions

import kotlin.IndexOutOfBoundsException

// This file demonstrates get and set operation overloading

fun main(args: Array<String>) {

    val point = Point(13, 42)
    println("${point[0]} ${point[1]}")

    val mutablePoint = MutablePoint(0, 0)
    mutablePoint[0] = 32
    mutablePoint[1] = 42
    println(mutablePoint)

}

operator fun MutablePoint.set(index: Int, value: Int) = when(index) {
    0 -> this.x = value
    1 -> this.y = value
    else -> throw java.lang.IndexOutOfBoundsException("MutablePoint only has two indices [index:0 = x, index:1 = y]")
}

operator fun Point.get(index: Int) = when (index) {
        0 -> this.x
        1 -> this.y
        else -> throw IndexOutOfBoundsException("Point only has two indices [index:0 = x, index:1 = y]")
    }