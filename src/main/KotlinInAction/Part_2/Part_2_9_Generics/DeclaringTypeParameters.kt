package main.KotlinInAction.Part_2.Part_2_9_Generics

// This file demonstrates the declaration of type parameters

interface Clickable<T> {

    fun click(click: T) {
        
    }

}