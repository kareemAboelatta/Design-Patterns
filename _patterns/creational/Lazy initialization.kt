package _patterns.creational

/**
 * Lazy initialization is a design pattern in which an object is only created or initialized when it is actually needed,
 * rather than being created or initialized during the object's instantiation or during the application's startup.
 * This pattern can help improve performance and reduce resource usage, as objects are only created or initialized when
 *  they are actually required, and not unnecessarily in advance.
 * */



class ExpensiveResource {
    init {
        // Simulate a resource-intensive initialization process
        println("Initializing ExpensiveResource...")
    }

    fun performOperation() {
        println("Performing an operation with ExpensiveResource")
    }
}



fun main() {
    val lazyResource: ExpensiveResource by lazy {
        println("Creating ExpensiveResource on first access...")
        ExpensiveResource()
    }

    // ExpensiveResource is not initialized until this line is reached
    println("Before accessing ExpensiveResource")

    // Access the resource, which triggers its initialization
    lazyResource.performOperation()

    // Access the resource again, it won't be re-initialized
    lazyResource.performOperation()
}



//old way
class LazyResourceHolder {
    private var initialized = false
    private var resource: ExpensiveResource? = null

    fun getLazyResource(): ExpensiveResource {
        if (!initialized) {
            println("Creating ExpensiveResource on first access...")
            resource = ExpensiveResource()
            initialized = true
        }
        return resource!!
    }
}










