package main.KotlinInAction.Part_2.Part_2_8_Higher_Order_Functions

// This file demonstrates how we can remove duplication through lambdas

fun main(args: Array<String>) {

    val duration = log.averageDuration { it.os == OS.WINDOWS && it.path == "/login" }
    println("$duration seconds")
}

/**
 * Calculates the average duration depending on the predicate
 */
fun List<SiteVisit>.averageDuration(predicate: (SiteVisit) -> Boolean): Double {
    return this.filter(predicate).map(SiteVisit::duration).average()
}

/**
 * Representation of a site visit
 * @param path The path of the website
 * @param duration The duration the user was on the website
 * @param os The Operating system the user is using
 */
data class SiteVisit(
    val path: String,
    val duration: Double,
    val os: OS
)

/**
 * The available operating systems
 */
enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

/**
 * A log of all the site visits made
 */
val log = listOf(
    SiteVisit("/", 34.0, OS.WINDOWS),
    SiteVisit("/", 22.0, OS.MAC),
    SiteVisit("/login", 12.0, OS.WINDOWS),
    SiteVisit("/signup", 8.0, OS.IOS),
    SiteVisit("/", 16.3, OS.ANDROID)
)