package _patterns.behavioral.template_method_pattern

abstract class AbstractClass {
    fun templateMethod() {
        stepOne()
        stepTwo()
        stepThree()
    }

    abstract fun stepOne()

    abstract fun stepTwo()

    abstract fun stepThree()
}

class ConcreteClass1 : AbstractClass() {
    override fun stepOne() {
        println("ConcreteClass1: Step One")
    }

    override fun stepTwo() {
        println("ConcreteClass1: Step Two")
    }

    override fun stepThree() {
        println("ConcreteClass1: Step Three")
    }
}

class ConcreteClass2 : AbstractClass() {
    override fun stepOne() {
        println("ConcreteClass2: Step One")
    }

    override fun stepTwo() {
        println("ConcreteClass2: Step Two")
    }

    override fun stepThree() {
        println("ConcreteClass2: Step Three")
    }
}

fun main() {
    val concrete1 = ConcreteClass1()
    concrete1.templateMethod()

    val concrete2 = ConcreteClass2()
    concrete2.templateMethod()
}

/*See Pizza example it so good too.*/

/**
 * The Template Method Design Pattern is a _patterns.behavioral design pattern that defines the skeleton of
 * an algorithm in a superclass, but allows subclasses to override specific steps of the algorithm without changing
 * its structure.
 *
 *
The Template Method Design Pattern consists of the following components:
-Abstract Class: Defines the abstract skeleton of the algorithm, including the steps that should be taken to complete it.
-Concrete Classes: Inherit from the Abstract Class and provide concrete implementations of the abstract methods defined
by the Abstract Class.
-Template Method: The method in the Abstract Class that defines the skeleton of the algorithm and calls the
abstract methods that will be overridden by the Concrete Classes.
-Hook Methods: Optional methods in the Abstract Class that the Concrete Classes can override to customize the behavior
of the algorithm.

The Template Method Design Pattern is useful when you have an algorithm that has multiple steps, some of which may
vary in implementation. By defining a skeleton in the abstract class and allowing subclasses to override specific steps,
you can easily create new variations of the algorithm without duplicating code.
 * */


/**
 * PitFalls
 * The Template Method Design Pattern, like any design pattern, has potential pitfalls that should be considered when using it:

Tight coupling: If the base class and the derived classes are tightly coupled, it may be difficult to change the
base class without affecting the derived classes.

Inflexibility: The Template Method Design Pattern may not be flexible enough for all situations. It is designed
to support a specific type of behavior, and trying to use it in situations where it is not appropriate may result in
less-than-optimal results.

Inversion of Control: Because the base class is responsible for defining the overall algorithm, there is an inversion
of control between the base class and the derived classes. This may make it difficult to add new behaviors to the
algorithm in the future.

Complexity: The Template Method Design Pattern can increase the complexity of the code, particularly if there
are a large number of derived classes or if the algorithm is particularly complex.
Maintenance: Because the Template Method Design Pattern relies on inheritance, changes to the base class can
have unintended consequences for the derived classes. This can make it more difficult to maintain the code over time.
 * */