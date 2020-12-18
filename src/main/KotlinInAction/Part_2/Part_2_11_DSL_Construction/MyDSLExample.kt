package main.KotlinInAction.Part_2.Part_2_11_DSL_Construction

import io.kotest.matchers.should
import io.kotest.matchers.string.startWith

// This file demonstrates the Kotlin DSL within Kotest

fun main(args: Array<String>) {
    val drop = create {
        id = 1
        amount = 2
        chance = 14.0
    }
    println(drop)
}

data class Drop(
    var id: Int = 0,
    var amount: Int = 0,
    var chance: Double = 0.0
)

// id define this inside a DropMap or DropList and name it `register` instead
fun create(init: DropBuilder.() -> Unit): Drop {
    val builder = DropBuilder().apply(init)
    val drop = builder.build()
    // do something with drop
    return drop
}

class DropBuilder(
    var id: Int = 0,
    var amount: Int = 0,
    var chance: Double = 0.0
) {

    fun build(): Drop {
        // can do some checks here, make sure values have been set (are not 0)
        return Drop(id, amount, chance)
    }
}

