# :heart: Design-Patterns :heart:
In this repository  i will practice on all Design Patterns by Kotlin .

# There are more than type of Design Patterns
* Behavioral
* Creational
* Structural

# Every type contain some _patterns under it category
## <img src="https://user-images.githubusercontent.com/62241386/228518747-4e5eedb2-e8fc-498c-9f21-ef515e006aef.png" >


# :star:Behavioral
* These _patterns are concerned with communication between objects, defining how they interact and operate with one another.
, "How objects interact together "

# :star:Creational Design Patterns:
* These _patterns are used to create objects in a way that is suitable for a particular situation. They deal with object creation mechanisms, trying to create objects in a manner suitable to the situation.

# :star:Structural Design Patterns:
* These _patterns deal with object composition, and they help to identify relationships between different objects, How _patterns.structural  of every object should be.

# :smile:Behavioral
### :thumbsup: Chain of Responsibility Pattern:
  - This pattern allows a group of objects to handle a request one by one until the request is processed successfully or no object can handle it.
###  :thumbsup: Command Pattern: 
- This pattern encapsulates a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.
###  :thumbsup: Interpreter Pattern:
- This pattern defines a grammatical representation for a language and an interpreter to evaluate this grammar.
###  :thumbsup: Iterator Pattern:
-  This pattern provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.
###  :thumbsup: Mediator Pattern:
- This pattern defines an object that encapsulates how a set of objects interact. This pattern promotes loose coupling by keeping objects from referring to each other explicitly.
###  :thumbsup: Memento Pattern:
- This pattern provides the ability to restore an object to its previous state.
###  :thumbsup: Observer Pattern:
- This pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
###  :thumbsup: State Pattern:
- This pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class.
###  :thumbsup: Strategy Pattern:
- This pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.
###  :thumbsup: Template Method Pattern:
 - This pattern defines the skeleton of an algorithm in a method, deferring some steps to subclasses. It lets subclasses redefine certain steps of an          algorithm without changing the algorithm's structure.
###  :thumbsup: Visitor Pattern:
- This pattern represents an operation to be performed on the elements of an object structure. Visitor lets you define a new operation without changing the classes of the elements on which it operates.



# :smile:Creational
### :large_blue_circle: Singleton:
- Ensures that only one instance of a class exists in the system and provides global access to that instance.
### :large_blue_circle: Factory Method:
- Defines an interface for creating objects, but allows subclasses to decide which class to instantiate.
### :large_blue_circle: Abstract Factory:
- Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
### :large_blue_circle: Builder: 
- Separates the construction of a complex object from its representation so that the same construction process can create different representations.
### :large_blue_circle: Prototype: 
- Creates new objects by copying existing ones and customizing their attributes as necessary.
### :large_blue_circle: Object Pool:
- Manages a pool of reusable objects for improved performance and memory management.
### :large_blue_circle: Lazy Initialization: 
- Delays the creation of an object or the calculation of a value until it is actually needed, rather than creating it upfront.




# :smile: Structural design patterns:

### 😵:Adapter Pattern: This pattern allows two incompatible interfaces to work together by creating a wrapper class that adapts the interface of one class to the interface of another.

### 😵:Bridge Pattern: This pattern decouples an abstraction from its implementation so that the two can vary independently. It involves creating two separate hierarchies, one for the abstraction and one for the implementation, and using composition to link them together.

### 😵:Composite Pattern: This pattern allows you to treat a group of objects in the same way as you would treat a single object. It involves creating a tree-like structure of objects, where each object can be either a leaf node (with no children) or a composite node (with children).

### 😵:Decorator Pattern: This pattern allows you to add behavior to an object dynamically at runtime, without affecting the behavior of other objects in the same class. It involves creating a wrapper class that mirrors the interface of the original class and adds additional functionality.

### 😵:Facade Pattern: This pattern provides a simplified interface to a complex system by encapsulating its various components behind a single interface. It involves creating a class that acts as a front-end for a set of classes or subsystems.

### 😵:Flyweight Pattern: This pattern allows you to share objects that are frequently used in order to reduce memory usage. It involves creating a factory class that manages a pool of shared objects and returns them as needed.

### 😵:Proxy Pattern: This pattern provides a placeholder for another object in order to control access to it. It involves creating a class that acts as a stand-in for another object and delegates requests to it as needed, while also adding additional functionality if necessary.

## In this repository i will impelement an example for  every pattern
