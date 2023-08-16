package _patterns.creational

object SingletonExample {
   public var x = 0
    init {
        println("Singleton instance has been created.")
    }

    fun doSomething() {
        println("Singleton is doing something. ${++x}")
    }
}

fun main() {
    println(SingletonExample.x)
    myFunction()
    SingletonExample.doSomething()
}


fun myFunction() {
    SingletonExample.doSomething()
}


/**
 * Just we wanna create one instance (object) from specific class in a whole project.
 * */

