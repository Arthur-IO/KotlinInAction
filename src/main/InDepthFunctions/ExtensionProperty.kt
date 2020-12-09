package main.InDepthFunctions

// This file demonstrates the use of an extension property in Kotlin

val String.lastChar: Char
    get() = get(length - 1)