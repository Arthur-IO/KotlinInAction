package main.KotlinInAction.Part_2.Part_2_9_Generics

// This file demonstrates how to set non-null types to type parameters

/**
 * A type parameter that specifies that it wants only non-null types
 */
class Processor<T: Any> {

    fun process(value: T) {
        value.hashCode()
    }

}

/**
 * A type parameter that specifies that it can accept nullable types
 *
 * Note: Any? is not required as T already has an upper-bound Any?
 * by default
 */
class ProcessorNullable<T: Any?> {

    fun process(value: T) {
        value.hashCode()
    }

}