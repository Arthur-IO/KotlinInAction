package main.KotlinInAction.Part_1.Part_1_6_The_Kotlin_Type_System

// This file demonstrates the usage of 'let'

fun main(args: Array<String>) {

    var email: String? = "arthur@gmail.com"
    email?.let { sendEmail(it) }

    email = null
    email?.let { sendEmail(email) }

}

fun sendEmail(email: String) = println(email)