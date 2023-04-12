package creational


data class Person(
    var firstName: String,
    var lastName: String,
    var age: Int,
    val address: String
) : Cloneable {

    public override fun clone(): Person {
        // Create a shallow copy of the object using Kotlin's copy() function
        return super.clone() as Person
    }

    fun displayInfo() {
        println("First Name: $firstName")
        println("Last Name: $lastName")
        println("Age: $age")
        println("Address: $address")
    }
}

fun main() {
    val john = Person("John", "Doe", 30, "1234 Elm St")
    val jane = john.clone() // Cloning john to create jane

    // Modifying the cloned object
    jane.firstName = "Jane"
    jane.lastName = "Smith"
    jane.age = 28

    // Displaying original and cloned objects
    println("-- Original Object --")
    john.displayInfo()

    println("-- Cloned Object --")
    jane.displayInfo()
}













/**
 *
The Prototype pattern is a creational design pattern that allows creating objects by cloning existing objects,instead of
creating new objects from scratch. The idea is to use a prototype object as a blueprint and create new objects by
copying the prototype, thereby avoiding the need to explicitly create each object and initialize its properties.

In other words, the Prototype pattern involves creating a clone or copy of an existing object, which serves as a prototype,
and then using that prototype to create new objects with the same properties and behavior.
This can be useful in scenarios where creating objects from scratch is expensive in terms of time or resources,
and it is more efficient to create new objects by cloning an existing one.

The Prototype pattern typically involves the following components:

-Prototype: This is the interface or abstract class that defines the common methods for cloning objects.
It typically includes a method, often called clone(), that creates a copy of the object.

-Concrete Prototype: This is the concrete implementation of the prototype interface or abstract class.
It implements the clone() method to create a copy of the object.

-Client: This is the client code that creates new objects by cloning the prototype. The client typically creates
an instance of the prototype, clones it, and then customizes the cloned object if needed.
 * */