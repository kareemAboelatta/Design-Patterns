package _patterns.behavioral.visitor_pattern




/**
 * Separate Algorithm (Area Calculation):
In the example, we want to calculate the area of each shape. Instead of adding the area calculation method directly to
each shape class (which would tightly couple the area calculation logic with the shape classes),
we create a separate ShapeVisitor interface. This interface declares a set of visit methods,
one for each shape type, representing the algorithm or operation we want to perform on the shape.
 * */



abstract class Shape {
    abstract fun accept(visitor: ShapeVisitor)
}




class Circle(val radius: Double) : Shape() {
    override fun accept(visitor: ShapeVisitor) {
        visitor.visitCircle(this)
    }
}

class Rectangle(val width: Double, val height: Double) : Shape() {
    override fun accept(visitor: ShapeVisitor) {
        visitor.visitRectangle(this)
    }
}

class Triangle(val base: Double, val height: Double) : Shape() {
    override fun accept(visitor: ShapeVisitor) {
        visitor.visitTriangle(this)
    }
}


interface ShapeVisitor {
    fun visitCircle(circle: Circle)
    fun visitRectangle(rectangle: Rectangle)
    fun visitTriangle(triangle: Triangle)
}


class AreaVisitor : ShapeVisitor {
    var totalArea = 0.0

    override fun visitCircle(circle: Circle) {
        totalArea += Math.PI * circle.radius * circle.radius
    }

    override fun visitRectangle(rectangle: Rectangle) {
        totalArea += rectangle.width * rectangle.height
    }

    override fun visitTriangle(triangle: Triangle) {
        totalArea += 0.5 * triangle.base * triangle.height
    }
}


fun main() {
    val shapes = listOf(
        Circle(5.0),
        Rectangle(2.0, 3.0),
        Triangle(4.0, 5.0)
    )

    val areaVisitor = AreaVisitor()


    for (shape in shapes) {
        shape.accept(areaVisitor)
    }

    println("Total area: ${areaVisitor.totalArea}")

}