package _patterns.behavioral.visitor_pattern

interface  MyShape{
    fun accept(visitor: MyAreaShapeVisitor)
}
class MyRectangle(val width: Double, val height: Double):MyShape {
    override fun accept(visitor: MyAreaShapeVisitor) {
        visitor.visitRectangle(this)
    }
}

class MyCircle(val radius: Double):MyShape {
    override fun accept(visitor: MyAreaShapeVisitor) {
        visitor.visitCircle(this)
    }
}

class MyTriangle(val base: Double, val height: Double):MyShape {
    override fun accept(visitor: MyAreaShapeVisitor) {
        visitor.visitTriangle(this)
    }
}

abstract class MyAreaShapeVisitor{
    abstract fun visitRectangle(rectangle: MyRectangle)
    abstract fun visitCircle(circle: MyCircle)
    abstract fun visitTriangle(triangle: MyTriangle)
}


class MyAreaShapeVisitorImp : MyAreaShapeVisitor() {
    var totalArea : Double = 0.0

    override fun visitRectangle(rectangle: MyRectangle) {
        val rectangleArea = rectangle.height * rectangle.width
        println("rectangleArea = $rectangleArea")
        totalArea += rectangleArea
    }

    override fun visitCircle(circle: MyCircle) {
        val circleArea = Math.PI * circle.radius * circle.radius
        println("circleArea = $circleArea")
        totalArea += circleArea
    }

    override fun visitTriangle(triangle: MyTriangle) {
        val triangleArea =  0.5 * triangle.base * triangle.height
        println("triangleArea = $triangleArea")
        totalArea += triangleArea
    }

}

fun main() {

    val triangle= MyTriangle(base = 10.0 , height = 10.0)
    val circle= MyCircle(radius = 4.0)
    val rectangle= MyRectangle(width = 10.0 , height = 5.0)
    val shapes = listOf(circle,triangle,rectangle)
    val myAreaShapeVisitor = MyAreaShapeVisitorImp()
    shapes.forEach{
        it.accept(myAreaShapeVisitor)
    }

    println(myAreaShapeVisitor.totalArea)

}