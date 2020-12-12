package main.KotlinInAction.Part_1.Part_1_4_Classes_Objects_And_Interfaces

// This file demonstrates the usage of an 'inner' and 'nested' class

/**
 * A simple class for demonstration of 'inner' and 'nested'
 */
class Outer {

    /**
     * Nested classes are analogous to 'static' within Java
     */
    class Nested { /*  Some nested class within outer  */ }

    /**
     * An implementation of an 'inner' class in Kotlin
     */
    inner class Inner {
        /**
         * A function that grabs the reference to the 'outer' class
         * where the 'inner' class is located
         */
        fun getOuterReference(): Outer = this@Outer
    }

}