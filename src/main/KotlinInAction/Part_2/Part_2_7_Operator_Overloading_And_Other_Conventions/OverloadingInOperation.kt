package main.KotlinInAction.Part_2.Part_2_7_Operator_Overloading_And_Other_Conventions

// This file demonstrates overloading the in operation

fun main(args: Array<String>) {

    val minimum = Point(0, 0)
    val maximum = Point(10, 10)
    val area = Area(minimum, maximum)

    println(Point(11, 5) in area)
    println(Point(5, 5) in area)

}

operator fun Area.contains(point: Point): Boolean {
    return point.x in this.minimum.x..this.maximum.x
            && point.y in this.minimum.y..this.maximum.y
}

data class Area(val minimum: Point, val maximum: Point)