package _patterns.structural

interface Widget{
    val name : String
}

class Text(override val name: String = "Text") : Widget
class Image(override val name: String = "Image") : Widget
class Button(override val name: String = "Button") : Widget


class Column(override val name: String="Column", private val children : MutableList<Widget>) : Widget {
    init{
        children.forEach{
            println(it.name)
        }
    }
}

class Row(override val name: String="Row", private val children : MutableList<Widget>) : Widget {
    init {
        children.forEach{
            print(" ${it.name} ")
        }
        println()
    }
}

class Container(override val name: String="Container", private val child : Widget ) : Widget {
    init {
        println("----------------")
        println("|${child.name}|")
        println("----------------")
    }
}


fun main() {


   Column(
        children = mutableListOf(
            Text(),
            Image(),
            Button(),
            Row(
                children = mutableListOf(
                    Text("Kareem"),
                    Text("Kamal"),
                )
            )
        )
    )

}


/**
 * The Composite pattern is a structural design pattern that allows you to treat individual objects and compositions
 * of objects uniformly. It involves creating a tree-like structure of objects where individual objects and composite
 * objects (comprised of multiple objects) are treated as if they were the same type of object.

The key components of the Composite pattern are:
-Component: This is the common interface or base class that represents both individual objects and composite objects.
It defines the common operations that can be performed on both types of objects.

-Leaf: This represents the individual objects in the composition. They implement the common interface defined by the Component.

-Composite: This represents the composite objects that can have child components. It also implements
the common interface defined by the Component, but it can also contain child components.

-The Composite pattern allows you to create complex hierarchies of objects and treat them uniformly as a single object.
It provides a way to represent part-whole relationships in a tree-like structure, where both individual objects
and composite objects can be manipulated in a consistent way.

 *
 * */



/** Programming scenario
 * # JetPack Compose Best Example to describe composite pattern and its name came form it.
 * */