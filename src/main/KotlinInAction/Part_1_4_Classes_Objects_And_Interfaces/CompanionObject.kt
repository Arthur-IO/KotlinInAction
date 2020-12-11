package main.KotlinInAction.Part_1_4_Classes_Objects_And_Interfaces

import java.io.File
import javax.jws.soap.SOAPBinding

// This file demonstrates the usage of a companion object

fun main(args: Array<String>) {
    // Demonstration of using a companion object as a factory
    for (i in 0 until 100) {
        val account = when(i % 3 == 0) {
            true -> Account.newSubscribingAccount("email-$i@gmail.com")
            else -> Account.newFacebookAccount(i)
        }
        AccountList.addAccount(account)
    }
    AccountList.allAccounts.forEach { println(it.nickname) }

    // Demonstration of using a companion object as a factory
    loadFromJSON(Account)
}

/**
 * A top-level function making a call to the 'companion object' of [AClass]
 */
fun callCompanion() {
    AClass.Companion.foo()
}

/**
 * A class used to demonstrate the usage of a 'companion object'
 */
class AClass {

    /**
     * 'Companion object's are declared using the 'companion' and 'object' keywords
     */
    companion object {

        /**
         * Some function that prints we are inside a companion object
         */
        fun foo() {
            println("A function within a companion object")
        }

    }
}

/**
 * An instance of our [AccountList] that holds all created accounts
 */
object AccountList {

    /**
     * An arraylist holding all the accounts
     */
    val allAccounts = arrayListOf<Account>()

    /**
     * Adds new or existing accounts into our account list
     */
    fun addAccount(account: Account) = allAccounts.add(account)

}

/**
 * An interface to parse something from a JSON text
 */
interface JSONFactory<T> {
    fun fromJSON(json: String): T
}

/**
 * A function that takes in a JSON factory and produces an element
 */
fun <T> loadFromJSON(factory: JSONFactory<T>) : T = factory.fromJSON("")

/**
 * A class that creates an [Account] object
 * @param nickname The nickname that the [Account] will have
 */
class Account private constructor(val nickname: String) {

    /**
     * A companion object that contains our factory for creating various [Account]s
     * as well implementing the [JSONFactory] interface requiring an implementation
     * of the interfaces funcction
     */
    companion object : JSONFactory<Account> {
        fun newSubscribingAccount(email: String): Account = Account(email.substringBeforeLast("@"))
        fun newFacebookAccount(facebookAccountId: Int): Account = Account("#$facebookAccountId")

        override fun fromJSON(json: String): Account {
            return TODO("")
        }

    }

}

/**
 * A class that represents a [Mob] in a hypothetical game world
 */
class Mob(val name: String) {

    /**
     * Named companion object
     */
    companion object Loader {
        fun parseMob(file: File): Mob = Mob(file.name)
    }

}

/**
 * An attack function extension on [Player]s companion object
 */
fun Player.Companion.attack() {}

/**
 * A function to demonstrate the usage of extension functions on companion objects
 */
class Player {

    companion object {

    }

}