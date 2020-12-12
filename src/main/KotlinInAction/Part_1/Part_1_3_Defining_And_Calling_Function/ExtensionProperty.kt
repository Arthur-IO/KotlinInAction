package main.KotlinInAction.Part_1.Part_1_3_Defining_And_Calling_Function

// This file demonstrates the use of an extension property in Kotlin

val String.lastChar: Char
    get() = get(length - 1)