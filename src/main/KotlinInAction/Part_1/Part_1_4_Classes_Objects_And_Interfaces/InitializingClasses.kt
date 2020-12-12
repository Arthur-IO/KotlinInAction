package main.KotlinInAction.Part_1.Part_1_4_Classes_Objects_And_Interfaces

// This file demonstrates how to initialize classes in Kotlin

/**
 * An open class with some properties
 */
open class User(
        val username: String,
        val password: String,
        val middleName: String = "",
        val nickName: String = ""
)

/**
 * A sub-class implementation of [User]
 */
class TwitterUser(
        username: String,
        password: String,
        middleName: String = "",
        nickName: String = ""
) : User(username, password, middleName, nickName)

/**
 * A class that has a 'private' constructor which means it cannot be
 * initialized outside of itself
 */
class Secretive private constructor()
