package main.KotlinInAction.Part_2.Part_2_9_Generics

class CustomTripleGenericClass<A: Any, B: Any, C: Any>(
    var first: A,
    var second: B,
    var third: C
) {

    fun printValue() = println("The type of first is ${first::class}")

}