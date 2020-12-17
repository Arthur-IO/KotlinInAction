package main.KotlinInAction.Part_2.Part_2_10_Annotations_And_Reflection

import ru.yole.jkid.joinToStringBuilder
import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.reflect.KProperty1
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberProperties

fun main(args: Array<String>) {

    val clazz = Te("irrelevant", "a new name", "hehehehe")
    println(saveO(clazz))
}

data class Te(
    @ExcludedVar
    val name: String,
    @ChangedName("Test")
    val name2: String,
    @ChangedName("2Annotations")
    @FormatterAnn(ReverseFormatter::class)
    val name3: String
)

fun saveO(obj: Any) = buildString { saveOAsJson(obj) }

fun StringBuilder.saveOAsJson(obj: Any) {
    obj.javaClass.kotlin.memberProperties.filter {
        filterExcluded(it)
    }.joinToStringBuilder(this, prefix = "{", postfix = "}") {
        saveProp(it, obj)
    }
}

fun StringBuilder.saveProp(prop: KProperty1<Any, *>, obj: Any) {
    val changedNameAnn = prop.findAnnotation<ChangedName>()
    val name = changedNameAnn?.newName ?: prop.name
    wrapInQuotes(name)
    append(": ")
    val value = prop.get(obj)
    val jsonValue = prop.getFormatter()?.toJSON(value) ?: value
    prepV(jsonValue)
}

fun StringBuilder.prepV(obj: Any?) {
    when(obj) {
        null -> append("null")
        is String -> wrapInQuotes(obj)
        is Number, is Boolean -> append(obj.toString())
        else -> saveOAsJson(obj)
    }
}

fun KProperty<*>.getFormatter(): Formatter<Any?>? {
    val formatterAnn = this.findAnnotation<FormatterAnn>()
    val formatter = formatterAnn?.formatter ?: return null
    val instance = formatter.objectInstance ?: formatter.createInstance()

    @Suppress("UNCHECKED_CAST")
    return instance as Formatter<Any?>
}

fun StringBuilder.wrapInQuotes(s: String) = append('\"').append(s).append('\"')

fun filterExcluded(obj: KProperty<*>): Boolean = obj.findAnnotation<ExcludedVar>() == null

@Target(AnnotationTarget.PROPERTY)
annotation class ExcludedVar

@Target(AnnotationTarget.PROPERTY)
annotation class ChangedName(val newName: String)

@Target(AnnotationTarget.PROPERTY)
annotation class FormatterAnn(val formatter: KClass<out Formatter<*>>)

interface Formatter<T> {
    fun toJSON(obj: T): T
}

class ReverseFormatter: Formatter<String> {
    override fun toJSON(obj: String): String = obj.reversed()
}