package _patterns.structural.bridge


/**
 * see third example this is the best example.
 * and note some multiplatform  frameworks use Bridge pattern like old react-native but flutter not .
 * The Bridge pattern is a structural design pattern that decouples an abstraction from its implementation,
 * allowing them to vary independently. It involves creating two separate hierarchies - one for abstraction and one for implementation
 * - and establishing a bridge between them through a separate abstraction interface.

The Bridge pattern is useful when you want to decouple an abstraction from its implementation, allowing them to
evolve independently. It provides flexibility in choosing different implementations for an abstraction at runtime,
without changing its interface.

The key components of the Bridge pattern are:

-Abstraction: This is the high-level interface or abstract class that defines the behavior of the abstraction.
    It typically contains abstract methods that represent the operations that can be performed on the abstraction.

-Refined Abstraction: This is the concrete class that extends the abstraction and adds additional behavior or customization.
It uses the abstraction interface to perform its operations.

-Implementation: This is the low-level interface or abstract class that defines the behavior of the implementation.
It typically contains abstract methods that represent the operations that can be performed on the implementation.


-Concrete Implementation: This is the concrete class that implements the implementation interface.
                            It provides the actual implementation of the operations defined in the implementation interface.

 * */



// Abstraction
abstract class Shape(var color: Color) {
    abstract fun draw()
}

// Refined Abstraction
class Circle(color: Color) : Shape(color) {
    override fun draw() {
        println("Drawing a Circle in ${color.getColor()}")
    }
}

// Refined Abstraction
class Square(color: Color) : Shape(color) {
    override fun draw() {
        println("Drawing a Square in ${color.getColor()}")
    }
}





// Implementation
interface Color {
    fun getColor(): String
}

// Concrete Implementation
class RedColor : Color {
    override fun getColor(): String {
        return "Red"
    }
}

// Concrete Implementation
class BlueColor : Color {
    override fun getColor(): String {
        return "Blue"
    }
}




fun main() {
    // Create a red circle
    val circle = Circle(RedColor())
    circle.draw()
    circle.color = BlueColor()
    circle.draw()



    // Create a blue square
    val blueSquare = Square(BlueColor())
    blueSquare.draw()
}
