package main.KotlinInAction.Part_2.Part_2_11_DSL_Construction

import kotlinx.html.stream.createHTML
import kotlinx.html.*

// This file demonstrates building HTML using KotlinX DSL

fun createSimpleTable() = createHTML().
    table {
        tr {
            td { + "cell" }
        }
    }

fun createComplexTable() = createHTML().table {
    val data = mapOf<String, String>("Username" to "Arthur-IO", "Password" to "KotlinIsCool", "Age" to "24")
    for ((key, value) in data) {
        tr {
            td { +key }
            td { value }
        }
    }
}