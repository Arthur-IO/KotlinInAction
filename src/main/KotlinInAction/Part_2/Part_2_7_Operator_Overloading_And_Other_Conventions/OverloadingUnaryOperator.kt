package main.KotlinInAction.Part_2.Part_2_7_Operator_Overloading_And_Other_Conventions

// This file demonstrates the overloading of unary operators (I.E: ++a   [ '++' being the unary operator])

fun main(args: Array<String>) {

    var point = Point(0, 0)
    println(++point)
    println(point++)
    println(point)

}

operator fun Point.inc(): Point {
    return Point(this.x + 1, this.y + 1)
}