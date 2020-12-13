package main.KotlinInAction.Part_2.Part_2_7_Operator_Overloading_And_Other_Conventions

// This file demonstrates the usage of database columns using delegated properties
// This demonstration requires the JetBrains "Exposed" framework

/*

class User(id: EntityID) : Entity(id) {
    var name: String by Users.name
    var age: Int by Users.age
}

object Users : IdTable() {
    val name: Column<String> = varchar("name", 50).index()
    val age: Column<Int> = integer("age")
}

*/