package main.KotlinInAction.Part_1_3_Defining_And_Calling_Function

// This file demonstrates the usage of regular expressions and triple quoted strings

fun main() {
    val absoluteFilePath = "/Users/Arthur/Desktop/Chocolate-bar.kt"

    parsePath(absoluteFilePath)
    println()
    parsePathRegex(absoluteFilePath)

    val tripleQuotedString = """
        =( ^  -  ^  ) =
           <(   )>
            /   \
    """
    print(tripleQuotedString)
}

/**
 * Parses all the contents of a file [path] using a regex and triple quoted string
 */
fun parsePathRegex(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()

    val matchResult : MatchResult? = regex.matchEntire(path)

    if(matchResult != null) {
        val (directory, fileName, extension) = matchResult.destructured
        print("Directory: $directory, Name: $fileName, Extension: $extension")
    }
}

/**
 * Parses all the contents of a file [path]
 */
fun parsePath(path: String) {

    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")
    print("Directory: $directory, Name: $fileName, Extension: $extension")
}


/**
 * This function implements th .toRegex method and prints a split string
 */
fun splitAString() {
    // Define a string  we want to split
    val str = "12.345-6.A"

    // Create our regex (Same syntax as Java)
    val myRegEx = "[.\\-]".toRegex()

    // Print the result
    println(str.split(myRegEx))

    // Overloaded way
    println(str.split(".", "-"))
}