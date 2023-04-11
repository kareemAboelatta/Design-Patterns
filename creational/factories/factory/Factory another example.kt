package creational.factories.factory

interface Button {
    fun display()
}

class WindowsButton : Button {
    override fun display() {
        println("Rendering a Windows style button.")
    }
}

class MacOSButton : Button {
    override fun display() {
        println("Rendering a MacOS style button.")
    }
}

class ButtonFactory {

    fun createButton(platform: String): Button {
        return when (platform) {
            "Windows" -> WindowsButton()
            "MacOS" -> MacOSButton()
            else -> throw IllegalArgumentException("Invalid platform: $platform")
        }
    }
}

fun main() {
    val buttonFactory = ButtonFactory()

    val windowsButton = buttonFactory.createButton("Windows")
    windowsButton.display() // Output: Rendering a Windows style button.

    val macOSButton = buttonFactory.createButton("MacOS")
    macOSButton.display() // Output: Rendering a MacOS style button.
}
