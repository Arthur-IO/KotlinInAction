package main.KotlinInAction.Part_2.Part_2_9_Generics

import java.lang.Appendable

// This file demonstrates type constraints

/**
 * An interface with a generic type, but has
 * Number as it's contract. This means that the type
 * cannot be anything other a Number.
 */
interface Scoreboard<T: Number> {
    val list: List<T>
}

/**
 * A function with an upper bound [Double]
 */
fun <T: Number> half(value: T): Double {
    return value.toDouble() / 2.0
}

/**
 * A function with an upper bound [Number]
 *
 * When an upperbound is specifeis on the type
 * that means that the value [T] can extend functions
 * of it's upper bound.
 */
fun <T: Number> toLong(value: T): Long {
    return value.toLong()
}

/**
 * Finds the maximum value of the two arguments passed
 */
fun <T: Comparable<T>> max(first: T, second: T): T {
    return if(first > second) first else second
}

/**
 * Ensures that passed argument ends with a period.
 * Sets two upper-bounds: CharSequence, Appendable
 */
fun <T> ensureTrailingPeriod(seq: T)
        where T: CharSequence, T: Appendable {
            if(!seq.endsWith('.'))
                seq.append('.')
        }