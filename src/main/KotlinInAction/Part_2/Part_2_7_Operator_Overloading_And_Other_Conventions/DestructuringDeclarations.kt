package main.KotlinInAction.Part_2.Part_2_7_Operator_Overloading_And_Other_Conventions

// This file demonstrates the destructuring of declarations for classes

fun main(args: Array<String>) {

    val (name, extension) = splitFilename("arthur.txt")
    println(name)
    println(extension)

}

data class NameComponent(val name: String, val extension: String)

fun splitFilename(fullName: String): NameComponent {
    val (name, extension) = fullName.split(".", limit = 2)
    return NameComponent(name, extension)
}