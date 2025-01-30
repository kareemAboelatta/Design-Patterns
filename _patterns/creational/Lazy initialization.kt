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



fun main1() {
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

class LazyHolder<T>(private val initializer: () -> T) {
    private var initialized = false

    private var resource: T? = null

    fun getLazyResource(): T {
        if (!initialized) {
            println("Creating ExpensiveResource on first access...")
            resource = initializer()
            initialized = true
        }
        return resource!!
    }

    var isInitialized = false
        get() = initialized
        private set
}



// Usage Example
class MyExpensiveResource {
    init {
        println("ExpensiveResource Created!")
    }
}

fun main() {
    val lazyHolder = LazyHolder { ExpensiveResource() } // Pass a lambda to create the instance
    val resource1 = lazyHolder.getLazyResource() // Creates the instance
    val resource2 = lazyHolder.getLazyResource() // Reuses the existing instance

    println(resource1 === resource2) // Should print true, confirming lazy initialization
}





