package main.KotlinInAction.Part_2.Part_2_11_DSL_Construction

import org.jetbrains.exposed.sql.Table

// This file demonstrates member extension functions on SQL

object Country : Table() {
    val id = integer("id").autoIncrement().primaryKey()
    val name = varchar("name", 50)
}