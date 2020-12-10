package main.KotlinInAction.Part_1_2_KotlinBasics

import java.util.Random

/**
 * This class demonstrates the usage of a custom accessor for
 * a property who's value does not need to be stored
 *
 * It also demonstrates the importing of a library
 *
 * It also demonstrates the usage of a top-level function
 */
class Rectangle(val height: Int, val width: Int) {

    /**
     * A property that checks whether the [Rectangle] is actually a square,
     * but does not have to store its value
     */
    val isSquare: Boolean
        get() {
            return height == width
        }

}

/**
 * A top-level function that creates a random rectangle
 * utilizing the [Random] utility within the Java utilities library
 */
fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}