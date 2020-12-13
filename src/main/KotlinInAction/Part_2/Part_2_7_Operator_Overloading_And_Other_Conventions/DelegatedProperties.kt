package main.KotlinInAction.Part_2.Part_2_7_Operator_Overloading_And_Other_Conventions

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.jvm.internal.Intrinsics
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

// This file demonstrates the usage of delegated properties

fun main(args: Array<String>) {

    val myPerson = KotlinPerson("Hi", 12, 13)

    myPerson.addPropertyChangeListener() {
        println(it.newValue)
        println(it.oldValue)
        println(it.propertyName)
    }

}

// Kotlin way of making delegated properties
class KotlinPerson(
    val name: String, age: Int, salary: Int
) : PropertyChangeAware() {
    private val observer = {
        prop: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
    var age: Int by Delegates.observable(age, observer)
    var salary: Int by Delegates.observable(salary, observer)
}


// Manual way of making delegated properties
class Person(
    val name: String, age: Int, salary: Int
) : PropertyChangeAware() {
    var age: Int by ObservableProperty(age, changeSupport)
    var salary: Int by ObservableProperty(salary, changeSupport)
}

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

class ObservableProperty(
    var propValue: Int, val changeSupport: PropertyChangeSupport
) {
    operator fun getValue(p: Person, prop: KProperty<*>): Int = propValue
    operator fun setValue(p: Person, prop: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}