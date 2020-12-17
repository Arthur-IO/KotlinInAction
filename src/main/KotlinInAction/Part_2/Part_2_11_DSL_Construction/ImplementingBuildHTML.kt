package main.KotlinInAction.Part_2.Part_2_11_DSL_Construction

// This file demonstrates how to implement some of the functions from BuildHTML

fun main(args: Array<String>) {
    table {
        tr {
            td {

            }
        }
    }
}

open class Tag(val name: String) {

    private val children = mutableListOf<Tag>()

    /**
     * Sets the receiver to the object
     * Then adds the tag to the list of children
     */
    protected fun <T: Tag> doInit(child: T, init: T.() -> Unit) {
        child.init()
        children.add(child)
    }

    override fun toString(): String =
        "<$name>${children.joinToString("")}</$name>"
}

fun table(init: TABLE.() -> Unit) = TABLE().apply(init)

class TABLE: Tag("table") {
    fun tr(init: TR.() -> Unit) = doInit(TR(), init)
}

class TR: Tag("tr") {
    fun td(init: TD.() -> Unit) = doInit(TD(), init)
}

class TD: Tag("td")