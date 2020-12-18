package main.KotlinInAction.Part_2.Part_2_11_DSL_Construction

import java.time.LocalDate
import java.time.Period

// This file demonstrates the usage of extension

fun main(args: Array<String>) {

    val yesterday = 1.days.ago
    val tomorrow = 1.days.fromNow

}

val Int.days: Period
    get() = Period.ofDays(this)

val Period.ago: LocalDate
    get() = LocalDate.now() - this

val Period.fromNow: LocalDate
    get() = LocalDate.now() + this