package _patterns.structural




/**
 * The Facade pattern is a structural design pattern that provides a simplified interface to a complex subsystem,
 * making it easier to use and understand. It encapsulates the complexity of multiple objects or subsystems behind a
 * single interface, providing a higher-level interface that clients can use to interact with the subsystem.

The Facade pattern is commonly used in situations where a system or subsystem is complex and has multiple components with
varying interfaces, and you want to provide a simpler, unified interface to interact with the subsystem.
It promotes loose coupling between the client and the subsystem, as the client interacts only with the facade,
which in turn interacts with the subsystem on behalf of the client.

Some key components of the Facade pattern are:
-Facade: This is the main class that provides a simplified interface for the clients to interact with the complex subsystem.
         It knows how to delegate client requests to the appropriate subsystem components,
         and it may also provide additional higher-level functionality.

-Subsystem: This is the complex subsystem or a set of related classes or components that perform specific tasks.
            Clients may need to interact with multiple subsystem components to achieve a desired result.

-Client: This is the class or component that interacts with the facade to use the simplified interface
         provided by the facade to interact with the subsystem. Clients are not aware of the complexity of
         the subsystem and interact only with the facade.
 * */

// Subsystem component 1
class Engine {
    fun start() {
        println("Engine started")
    }

    fun stop() {
        println("Engine stopped")
    }
}

// Subsystem component 2
class FuelSystem {
    fun pumpFuel() {
        println("Fuel pumped")
    }

    fun stopFuelPump() {
        println("Fuel pump stopped")
    }
}

// Subsystem component 3
class IgnitionSystem {
    fun ignite() {
        println("Ignition system ignited")
    }

    fun turnOff() {
        println("Ignition system turned off")
    }
}

// Facade
class CarFacade {
    private val engine = Engine()
    private val fuelSystem = FuelSystem()
    private val ignitionSystem = IgnitionSystem()

    fun startCar() {
        println("Starting the car...")
        engine.start()
        fuelSystem.pumpFuel()
        ignitionSystem.ignite()
        println("Car started")
    }

    fun stopCar() {
        println("Stopping the car...")
        engine.stop()
        fuelSystem.stopFuelPump()
        ignitionSystem.turnOff()
        println("Car stopped")
    }
}

// Client
fun main() {
    val carFacade = CarFacade()

    // Start the car
    carFacade.startCar()  // client don't want to know how it work he just want to use it. like retrofit

    // Stop the car
    carFacade.stopCar()
}


/**
 * Programing scenario
 * In android when i use retrofit i don't want to know how it work, i just use it to make server API call
 * I SEE NOTHING ABOUT IT. It use some complex class I don't wanna know about them (e.g. OkHttp).
 *
 *
 *
 * */



















