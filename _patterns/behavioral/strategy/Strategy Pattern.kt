package _patterns.behavioral.strategy


// Strategy interface
interface MathStrategy {
    fun doOperation(a: Int, b: Int): Int

}

// Concrete Strategy classes
class AdditionStrategy : MathStrategy {
    override fun doOperation(a: Int, b: Int): Int {
        return a + b
    }
}

class SubtractionStrategy : MathStrategy {
    override fun doOperation(a: Int, b: Int): Int {
        return a - b
    }
}

class MultiplicationStrategy : MathStrategy {
    override fun doOperation(a: Int, b: Int): Int {
        return a * b
    }
}



// Context class
class MathOperation(private var strategy: MathStrategy) {
    fun setStrategy(strategy: MathStrategy) {
        this.strategy = strategy
    }

    fun executeOperation(a: Int, b: Int): Int {
        return strategy.doOperation(a, b)
    }
}


// Example usage
fun main() {
    val mathOperation = MathOperation(AdditionStrategy())

    // Execute the operation using the current strategy
    val result1 = mathOperation.executeOperation(5, 3) // now my current behavior (algorithm) is Addition
    println("Current Behavior (algorithm) is Addition: $result1")

    // Set the strategy to SubtractionStrategy
    mathOperation.setStrategy(SubtractionStrategy()) // now my current behavior (algorithm) is Subtraction

    // Execute the operation using the current strategy
    val result2 = mathOperation.executeOperation(5, 3)

    println("Current Behavior (algorithm) is Subtraction: $result2")
}


/**
 * The Strategy Design Pattern is a _patterns.behavioral pattern that allows you to define a family of algorithms,
 * encapsulate each one of them, and make them interchangeable.
 *
 * This pattern allows the algorithms to be chosen at runtime based on the requirement of the client without changing
 * the code that uses it.
 *
 * The Strategy Design Pattern is a _patterns.behavioral design pattern that allows objects to dynamically change
 * their behavior at runtime by selecting from multiple algorithms or strategies to accomplish a particular task.


The Strategy pattern consists of multiple parts:

1-Context: Context is the entry point for the client where it initiates the execution of the algorithm.

2-Strategy: It is an interface that defines the contract for the algorithms. All the algorithms implement
this interface to ensure that they adhere to the same contract.

3-Concrete Strategy: It is the actual implementation of the algorithm that performs the desired operation.




Advantages of using the Strategy Design Pattern:

Flexibility: The Strategy Pattern provides flexibility by allowing you to switch algorithms at runtime.

Code reusability: By encapsulating the algorithms, it promotes code reusability.

Leverage Polymorphism: The Strategy Design Pattern utilizes polymorphism and ensures that the interfaces are
well defined, making the code more manageable and maintainable.

Separation of Concerns: By separating the algorithms from the client code, it simplifies the complexity and allows you
to focus on individual components.


 * */









/**
 * Pitfalls:
 * - client has to know about strategies
 * - increase number of classes
 * */
















