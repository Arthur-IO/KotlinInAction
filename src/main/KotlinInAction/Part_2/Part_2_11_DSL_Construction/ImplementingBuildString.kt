package main.KotlinInAction.Part_2.Part_2_11_DSL_Construction

import java.lang.StringBuilder

// This file demonstrates the building of buildString function using Kotlin DSL

fun main(args: Array<String>) {

    buildString {
        append("hi")
    }

    queue {
        attack("The world")
        sleep(5000)
        eatFood()
        attack("The World")
        sleep(2000)
        eatFood()
    }

    println(
        buildString {
            append("Hi").appendExcel()

        }
    )

    println(buildString(appendExcel))

}

val appendExcel: StringBuilder.() -> Unit =
    { this.append("!") }

fun buildString(
    builderAction: StringBuilder.() -> Unit
) = StringBuilder().apply(builderAction).toString()

fun queue(
    queue: Player.() -> Unit
) = Player().apply(queue)

class Player {

    fun attack(obj: Any) {
        println("You just attacked ${obj.toString()}")
    }

    fun eatFood() {
        println("Eating food")
    }

    fun sleep(timeAsLong: Long) {
        Thread.sleep(timeAsLong)
    }

}