
/**
The Flyweight pattern is a structural design pattern that aims to reduce the memory usage and
improve performance by sharing common parts of objects instead of duplicating them. It is commonly used in
situations where a large number of objects need to be created and managed,and memory usage is a concern.

The main idea behind the Flyweight pattern is to separate the intrinsic(جوهرية) state (i.e., shared state)
from the extrinsic(خارجية) state (i.e., unique state) of objects.

The intrinsic state is the part of the object that can be shared among multiple objects,
while the extrinsic state is the part that varies for each object. By separating these two states,
the Flyweight pattern allows objects with similar intrinsic state to share the same memory space,
thereby reducing memory usage.

The Flyweight pattern typically involves the following components:

-Flyweight: This is the interface or abstract class that defines the common interface for the flyweight objects.
It usually contains methods that operate on the intrinsic state.

-Concrete Flyweight: This is the concrete implementation of the Flyweight interface,
which represents the flyweight objects that can be shared. It usually contains the intrinsic state and implements the

methods defined in the Flyweight interface.

-Flyweight Factory: This is a factory class that creates and manages the flyweight objects.It ensures that
flyweight objects are shared and reused, and it may also handle the creation of new flyweight objects when needed.

-Client: This is the client code that uses the flyweight objects. It typically contains the extrinsic state
that is unique to each object, and it may also interact with the flyweight factory to create or access flyweight objects.
 * */





// Flyweight interface
interface Shape {
    fun draw(color: String)
}

// Concrete Flyweight
class Circle : Shape {
    private val radius: Int = 5

    override fun draw(color: String) {
        println("Drawing a $color circle with radius $radius")
    }
}

// Flyweight Factory
class ShapeFactory {
    private val circleMap: MutableMap<String, Shape> = mutableMapOf()

    fun getCircle(color: String): Shape {
        var circle = circleMap[color]
        if (circle == null) {
            circle = Circle()
            circleMap[color] = circle
            println("Creating a new circle of $color color")
        }
        return circle
    }
}

// Client
fun main() {
    val shapeFactory = ShapeFactory()

    // Drawing circles of different colors
    val colors = arrayOf("red", "blue", "green", "red", "yellow", "blue", "green", "yellow","black")
    for (color in colors) {
        val circle = shapeFactory.getCircle(color)
        circle.draw(color)
    }
}
/*Note
* In the example of the Flyweight pattern provided, the intrinsic state refers to the properties or characteristics of
* the Circle object that can be shared among multiple objects, while the extrinsic state refers to the properties or
*  characteristics of the Circle object that are unique to each object.

In the given example, the intrinsic state of the Circle object is the radius, which is set to a fixed value of 5 for
* all circles. This radius property is shared among all Circle objects created by the ShapeFactory,
* and it does not change regardless of the color of the circle or the number of times it is drawn.

On the other hand, the extrinsic state of the Circle object is the color, which is passed as an argument to the draw() method.
*  The color property is unique to each Circle object, and it varies depending on the color specified
* by the client when drawing the circle.
*  This extrinsic state is not shared among multiple Circle objects and can vary for each object.

By separating the intrinsic state (i.e., radius) from the extrinsic state (i.e., color),
* the Flyweight pattern allows the Circle objects to share the same intrinsic state (i.e., radius)
* and avoid duplication of this shared state, thereby reducing memory usage. The extrinsic state (i.e., color)
* is managed separately for each Circle object and is not shared among objects, allowing for customization and variation.
* */