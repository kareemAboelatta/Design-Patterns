package _patterns.structural.proxy

/**
 * Proxy Pattern
 *
 * Definition:
 * Proxy provides a surrogate or placeholder object that controls access
 * to another object (the real object).
 *
 * Why Proxy?
 * - Lazy loading (create heavy objects only when needed)
 * - Caching results
 * - Security / permission checks
 * - Logging or monitoring
 *
 * Structure:
 * Client -> Proxy -> Real Object
 *
 * The client works with an interface and does not know
 * whether it is talking to the real object or a proxy.
 */
val Proxy_Pattern= "Proxy_Pattern"
/**
 * Subject interface
 * Both Real object and Proxy implement this
 */
interface UserService {
    fun getUser(): String
}

/**
 * Real Object
 * This simulates an expensive operation (network / database)
 */
class RealUserService : UserService {

    init {
        println("RealUserService created")
    }

    override fun getUser(): String {
        println("Fetching user from network...")
        Thread.sleep(1000) // simulate delay
        return "User from API"
    }
}

/**
 * Proxy Object
 *
 * Responsibilities:
 * - Controls access to RealUserService
 * - Creates it lazily
 * - Caches the result
 */
class UserServiceProxy : UserService {

    private var realService: RealUserService? = null
    private var cachedUser: String? = null

    override fun getUser(): String {

        // Return cached data if available
        if (cachedUser != null) {
            println("Returning cached user")
            return cachedUser!!
        }

        // Lazy initialization
        if (realService == null) {
            realService = RealUserService()
        }

        cachedUser = realService!!.getUser()
        return cachedUser!!
    }
}

/**
 * Client code
 *
 * The client depends only on the interface.
 * It does not know if it is using a Proxy or the Real object.
 */
fun main() {

    val userService: UserService = UserServiceProxy()

    println("First call:")
    println(userService.getUser())

    println("\nSecond call:")
    println(userService.getUser())
}
