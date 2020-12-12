package main.KotlinInAction.Part_1.Part_1_4_Classes_Objects_And_Interfaces

// This file demonstrates interfaces with abstract properties

/**
 * An interface with an abstract property
 */
interface Component {
    val id: String
}

/**
 * An implementation of [Component] with initialized property
 */
class Ram(val partNumber: Int): Component {
    override val id: String
        get() = "#$partNumber"
}

/**
 * An implementation of [Component] with initialized property
 */
class Case(val caseName: String): Component {
    override val id: String
        get() = "__$caseName"
}

/**
 * An implementation of [Component] with initialized property
 */
class CPU(val cpuName: String, val brand: String): Component {
    override val id: String = createId()

    fun createId() = "${brand}_$cpuName"

}
