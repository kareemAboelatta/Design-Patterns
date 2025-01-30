package _patterns.creational.factories.factory



interface Shape {
    fun draw()
}

class Circle : Shape {
    override fun draw() {
        println("Drawing a circle")
    }
}

class Rectangle : Shape {
    override fun draw() {
        println("Drawing a rectangle")
    }
}



//- Factory:
class ShapeFactory {
    fun createShape(type: String): Shape? {
        return when (type) {
            "circle" -> Circle()
            "rectangle" -> Rectangle()
            else -> null
        }
    }
}

fun main() {
    val shapeFactory = ShapeFactory()

    val shape1 = shapeFactory.createShape("circle")
    shape1?.draw() // Output: Drawing a circle
    println("shape1 is a circle ? ::: ${(shape1 is Circle)}")

    val shape2 = shapeFactory.createShape("rectangle")
    shape2?.draw() // Output: Drawing a rectangle

    val shape3 = shapeFactory.createShape("triangle")
    shape3?.draw() // Output: null
}





/**
 *
 * The Factory Design Pattern is a Creational Design Pattern that provides an interface for creating objects in a
 * super class, but allows subclasses to alter the type of objects that will be created.
 * It encapsulates the object creation logic in a separate class, called the factory,
 * which is responsible for creating instances of the appropriate concrete classes based on some conditions.

The Factory Design Pattern is useful in scenarios where you need to create objects of different types, but you want to
abstract away the details of object creation and decouple the client code from the concrete classes being created.
It promotes loose coupling between objects and provides a simple way to create objects
without exposing the instantiation logic to the client code.

Some key components of the Factory Design Pattern are:
- Product: The interface or abstract class that defines the common methods that all products (objects) created by
  the factory must implement.

- Concrete Product: The actual implementation of the Product interface or abstract class.
  These are the objects that are created by the factory.

- Factory: The class responsible for creating objects of different types based on some conditions.
  It usually contains a factory method or methods that return instances of the concrete products based on input
  parameters or conditions.
 * */
const val Factory = "Factory"



