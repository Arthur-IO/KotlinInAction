package main.KotlinInAction.Part_1_4_Classes_Objects_And_Interfaces

import java.io.File

// This file demonstrates the usage of the 'object' keyword

fun main(args: Array<String>) {
    val files = listOf<File>(File("/d"), File("/D"))
    println(files.sortedWith(CaseInsensisitiveFileComparer))
}

/**
 * Singleton reference to an insensitive file path comparator
 */
object CaseInsensisitiveFileComparer : Comparator<File> {

    /**
     * Compares a [File] path to another [File] path
     */
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }

}

/**
 * A simple class to allow us to implement a [Payroll]
 */
class Employee()

/**
 * A singleton instance of the class Payroll defined by the 'object' keyword
 */
object Payroll {

    val employees = arrayListOf<Employee>()

    fun calculateSalary() {
        for (e in employees) {
            println("Payroll calculated")
        }
    }

}