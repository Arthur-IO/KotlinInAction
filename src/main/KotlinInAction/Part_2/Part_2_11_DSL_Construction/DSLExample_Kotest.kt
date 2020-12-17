package main.KotlinInAction.Part_2.Part_2_11_DSL_Construction

import io.kotest.matchers.should
import io.kotest.matchers.string.startWith

// This file demonstrates the Kotlin DSL within Kotest

fun main(args: Array<String>) {
    create drop 10 amount 5
}

data class Drop(
    val itemId: Int,
    var itemAmount: Int = 1
)

object create

infix fun create.drop(id: Int) = Drop(itemId = id)

infix fun Drop.amount(amount: Int): Drop {
    this.itemAmount = amount
    println("Drop created: $this")
    return this
}