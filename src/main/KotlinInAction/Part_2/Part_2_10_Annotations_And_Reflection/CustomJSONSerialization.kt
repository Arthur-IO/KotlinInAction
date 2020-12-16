package main.KotlinInAction.Part_2.Part_2_10_Annotations_And_Reflection

import ru.yole.jkid.*
import ru.yole.jkid.deserialization.deserialize
import ru.yole.jkid.serialization.serialize
import java.text.SimpleDateFormat
import java.util.*

// This file demonstrates how to customize JSON serialization

fun main(args: Array<String>) {

    val art = Person("Arthur Behesnilian", 24, MyClass("foo"), Date())
    val json = serialize(art)
    println(json)

    val personDeserialized = deserialize<Person>(json)
    println(personDeserialized)
    personDeserialized.myClass.foo()
}

data class Person(
    @JsonName("full_name") // changes the variable name to whats specified during serialization/deserialization
    @CustomSerializer(NameSerializer::class)
    val name: String,
//  @JsonExclude // excludes the variable during serialization/deserialization
    val age: Int,
    @DeserializeInterface(MyClass::class)
    // What this annotation does is during serialization it deserializes an instance of the [MyClass]
    // interface and stores it within the myClass property
    val myClass: MyClass,
    @CustomSerializer(DateSerializer::class) // Serializes this property in a special way
    val birthDate: Date
)

interface MyInterface {
    val fooName: String

    fun foo()

}

data class MyClass(override val fooName: String) : MyInterface {
    override fun foo() {
        println("My class impl of foo")
    }
}

/**
 * A custom way to serialize a date object
 */
object DateSerializer : ValueSerializer<Date> {
    private val dateFormat = SimpleDateFormat("dd-mm-yyyy")

    override fun toJsonValue(value: Date): Any? =
        dateFormat.format(value)

    override fun fromJsonValue(jsonValue: Any?): Date =
        dateFormat.parse(jsonValue as String)
}

/**
 * A custom way to serialize a string object
 */
object NameSerializer: ValueSerializer<String> {

    override fun fromJsonValue(jsonValue: Any?): String = (jsonValue as String).replace("_", " ")

    override fun toJsonValue(value: String): Any? = value.replace(" ", "_")

}