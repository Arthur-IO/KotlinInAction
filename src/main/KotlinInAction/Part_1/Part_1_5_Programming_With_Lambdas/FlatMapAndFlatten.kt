package main.KotlinInAction.Part_1.Part_1_5_Programming_With_Lambdas

// This file demonstrates the usage of 'flatMap' and 'flatten'

fun main(args: Array<String>) {
    val library = listOf<Book>(Book("I love Audrey", arrayListOf("Arthur Behesnilian")),
                                Book("Holy Bible", arrayListOf("Jesus", "God")),
                                Book("A Random Book", arrayListOf("Unknown Author")))

    val listOfList = arrayListOf<ArrayList<String>>()
    //listOfList.flatten() Allows you to take the list of lists and flatten it all down into one list

    val authors = library.flatMap { book: Book -> book.authors }.toSet()
    println(authors)

}

class Book(val bookName: String, val authors: ArrayList<String>)

