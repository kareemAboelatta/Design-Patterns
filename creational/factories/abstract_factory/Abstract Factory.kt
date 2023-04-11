package creational.factories.abstract_factory


interface Button {
    fun display()
}

interface Checkbox {
    fun display()
}

class WindowsButton : Button {
    override fun display() {
        println("Rendering a Windows style button.")
    }
}

class WindowsCheckbox : Checkbox {
    override fun display() {
        println("Rendering a Windows style checkbox.")
    }
}

class MacOSButton : Button {
    override fun display() {
        println("Rendering a MacOS style button.")
    }
}

class MacOSCheckbox : Checkbox {
    override fun display() {
        println("Rendering a MacOS style checkbox.")
    }
}

interface GUIFactory {
    fun createButton(): Button
    fun createCheckbox(): Checkbox
}

class WindowsGUIFactory : GUIFactory {
    override fun createButton(): Button {
        return WindowsButton()
    }

    override fun createCheckbox(): Checkbox {
        return WindowsCheckbox()
    }
}

class MacOSGUIFactory : GUIFactory {
    override fun createButton(): Button {
        return MacOSButton()
    }

    override fun createCheckbox(): Checkbox {
        return MacOSCheckbox()
    }
}

class Application(private val guiFactory: GUIFactory) {
    fun renderUI() {
        val button = guiFactory.createButton()
        val checkbox = guiFactory.createCheckbox()

        button.display()
        checkbox.display()
    }
}

fun main() {
    val platform = "Windows" // or "MacOS"

    val guiFactory = when (platform) {
        "Windows" -> WindowsGUIFactory()
        "MacOS" -> MacOSGUIFactory()
        else -> throw IllegalArgumentException("Invalid platform: $platform")
    }

    val application = Application(guiFactory)
    application.renderUI()
}


/**
 * The Abstract Factory Design Pattern is a Creational Design Pattern that provides an interface for
 * creating families of related or dependent objects without specifying their concrete classes.
 * It allows creating objects that are related and designed to work together in a unified way.

The Abstract Factory Design Pattern is useful in scenarios where you need to create objects that
belong to a common family or group, but you want to abstract away the details of object creation and
provide a common interface for creating objects of different types or variants.
It promotes loose coupling between objects and provides a way to ensure that objects created by a factory are compatible
and work together seamlessly.

Some key components of the Abstract Factory Design Pattern are:
- Abstract Factory: The interface or abstract class that defines the common methods for creating objects of
different types or variants. It encapsulates the creation logic for a family of related objects.

- Concrete Factory: The actual implementation of the Abstract Factory interface or abstract class.It provides the concrete
implementation of the methods defined in the Abstract Factory, which create objects of different types or variants.

- Abstract Product: The interface or abstract class that defines the common methods that all products (objects)
created by the Abstract Factory must implement. These products are related or dependent on each other.

- Concrete Product: The actual implementation of the Abstract Product interface or abstract class.
These are the objects that are created by the Concrete Factory and belong to a common family or group.

 *
 * */












