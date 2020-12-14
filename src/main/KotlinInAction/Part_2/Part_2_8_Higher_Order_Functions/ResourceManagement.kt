package main.KotlinInAction.Part_2.Part_2_8_Higher_Order_Functions

import java.io.BufferedReader
import java.io.FileReader

// This file demonstrates the usage of resource management in Kotlin

/**
 * Here we use use the 'use' function which is used on a
 * [CloseableKt] object which will close the resource
 * once it has been used and dealt with
 */
fun readFirstLineFromFile(path: String): String {
    BufferedReader(FileReader(path)).use { br ->
        return br.readLine()
    }
}