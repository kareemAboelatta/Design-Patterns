package creational

object SingletonExample {
    init {
        println("Singleton instance has been created.")
    }

    fun doSomething() {
        println("Singleton is doing something.")
    }
}

fun main() {
    myFunction()
    SingletonExample.doSomething()
}


fun myFunction() {
    SingletonExample.doSomething()
}