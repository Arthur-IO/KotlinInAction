package main.KotlinInAction.Part_2.Part_2_10_Annotations_And_Reflection

import ru.yole.jkid.joinToStringBuilder
import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.reflect.KProperty1
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberProperties


// This file demonstrates how to implement object serialization

fun main(args: Array<String>) {
    // First we create an object for something
    // Then we want to save the object as a JSON String
        // 1. Filter all variables we don't want to include
        // 2. Save every property
            // a. Check if we should change the name of the property
                // i. Make sure to wrap the property name in string
            // b. Check if we have a custom formatter
                // i. If we have a custom formatter then format
                // ii. If not then just use the normal value
            // c. Make sure to append correctly by type

    val clazz = SomeClass("irrelevant", "they are!", "carbine")
    val json = saveObj(clazz)
    println(json)
}

/**
 * Some class to test our annotations with
 */
data class SomeClass(
    @ExcludeName
    val someExcludedName: String,
    @ChangeName("AnnotationsAreCool")
    val someOtherName: String,
    @CustomFormatterAnn(ReverseStringFormatter::class)
    val someCoolName: String
)

/**
 * A formatter that reverses the string that the annotation is applied
 */
class ReverseStringFormatter: CustomFormatter<String> {
    override fun formatValue(obj: String): String = obj.reversed()
}

/**
 * Returns the JSON equivalent of the object argument
 */
fun saveObj(obj: Any) = buildString { saveObjAsJSON(obj) }

/**
 * A string builder that builds a JSON equivalent of the object argument
 */
fun StringBuilder.saveObjAsJSON(obj: Any) {
    // The reference to the kclass
    val clazz = obj.javaClass.kotlin
    clazz.memberProperties
        // Filters all properties that are marked with [ExcludeName] annotation
        .filter { filterExcludedNames(it) }
        // Uses a join to string function to iterate over all the properties and create a json object
        .joinToStringBuilder(this, prefix = "{", postfix = "}") {
            saveProperty(it, obj)
        }
}

/**
 * Saves a property
 * @param prop The [KProperty1] that is being saved
 * @param obj The object argument we are saving
 */
fun StringBuilder.saveProperty(prop: KProperty1<Any, *>, obj: Any) {
    val changeNameAnn = prop.findAnnotation<ChangeName>()
    val name = changeNameAnn?.newName ?: prop.name
    wrap(name)
    append(": ")
    val value = prop.get(obj)
    val jsonValue = prop.getCustomFormatter()?.formatValue(value) ?: value
    prepValue(jsonValue)
}

/**
 * Prepares a property to be saved based on its type
 */
fun StringBuilder.prepValue(obj: Any?) {
    when(obj) {
        null -> append("null")
        is String -> wrap(obj)
        is Number, is Boolean -> append(obj.toString())
        else -> saveObjAsJSON(obj)
    }
}

/**
 * Finds a [CustomFormatter] if the property contains a [CustomFormatterAnn]
 */
fun KProperty<*>.getCustomFormatter(): CustomFormatter<Any?>? {
    val customFormatterAnn = this.findAnnotation<CustomFormatterAnn>()
    val customFormatter = customFormatterAnn?.customFormatter ?: return null

    val instance = customFormatter.objectInstance ?: customFormatter.createInstance()

    @Suppress("UNCHECKED_CAST")
    return instance as CustomFormatter<Any?>
}

/**
 * Wraps a string in quotations
 */
fun StringBuilder.wrap(s: String) = append('\"').append(s).append('\"')

/**
 * A filter for [ExcludeName] annotation
 * @param prop The property to check
 */
fun filterExcludedNames(prop: KProperty<*>): Boolean = prop.findAnnotation<ExcludeName>() == null

// All our annotations
@Target(AnnotationTarget.PROPERTY)
annotation class ExcludeName

@Target(AnnotationTarget.PROPERTY)
annotation class ChangeName(val newName: String)

@Target(AnnotationTarget.PROPERTY)
annotation class CustomFormatterAnn(val customFormatter: KClass<out CustomFormatter<*>>)

interface CustomFormatter<T> {
    fun formatValue(obj: T): T
}
