package _patterns.structural


/**
 * The Decorator pattern is a structural design pattern that allows behavior to be added to an individual object,
 * either statically or dynamically, without affecting the behavior of other objects from the same class.
 * It is a structural pattern that involves a set of decorator classes that are used to wrap concrete components.
 * Decorator classes mirror the type of the components they decorate (they implement the same interface)
 * but add or override behavior.

The Decorator pattern is useful when you want to add behavior to objects at runtime without modifying their existing code.
It provides a flexible alternative to subclassing for extending functionality of individual objects,
allowing you to add or modify behavior of objects dynamically during runtime.

The key components of the Decorator pattern are:

-Component: This is the common interface or abstract class that represents the basic functionality of objects that
    can be decorated. It defines the common methods that the concrete components and decorators must implement.

-Concrete Component: This is the concrete class that implements the component interface.
    It represents the base object to which additional behavior can be added.

-Decorator: This is the abstract class or interface that defines the common interface for all decorators.
    It holds a reference to a component object and implements the same interface as the component.
    It may also provide default behavior or additional fields or methods.
-Concrete Decorator: This is the concrete class that adds or overrides behavior of the component it decorates.
    It extends the decorator class and implements the additional behavior.
 *
 *
 * */
// Component
interface Coffee {
    fun getDescription(): String
    fun getCost(): Double
}

// Concrete Component
class SimpleCoffee : Coffee {
    override fun getDescription(): String {
        return "Simple Coffee"
    }

    override fun getCost(): Double {
        return 1.0
    }
}

// Decorator
abstract class CoffeeDecorator(private val decoratedCoffee: Coffee) : Coffee {
    override fun getDescription(): String {
        return decoratedCoffee.getDescription()
    }

    override fun getCost(): Double {
        return decoratedCoffee.getCost()
    }
}




// Concrete Decorator
class Milk(private val coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun getDescription(): String {
        return super.getDescription() + ", Milk"
    }

    override fun getCost(): Double {
        return super.getCost() + 0.5
    }
}

// Concrete Decorator
class Sugar(private val coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun getDescription(): String {
        return super.getDescription() + ", Sugar"
    }

    override fun getCost(): Double {
        return super.getCost() + 0.2
    }
}


fun main() {


    // Create a simple coffee
    val simpleCoffee: Coffee = SimpleCoffee()
    println("Simple Coffee: ${simpleCoffee.getDescription()}, Cost: ${simpleCoffee.getCost()}")

    // Decorate with milk
    val coffeeWithMilk = Milk(simpleCoffee)
    println("Coffee with Milk: ${coffeeWithMilk.getDescription()}, Cost: ${coffeeWithMilk.getCost()}")

    // Decorate with milk and sugar
    val coffeeWithMilkAndSugar: Coffee = Sugar(coffeeWithMilk)
    println("Coffee with Milk and Sugar: ${coffeeWithMilkAndSugar.getDescription()}, Cost: ${coffeeWithMilkAndSugar.getCost()}")


}




