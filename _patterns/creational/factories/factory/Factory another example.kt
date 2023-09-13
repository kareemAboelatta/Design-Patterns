package _patterns.creational.factories.factory

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







enum class PlatformType{ WINDOWS,MAC}
class ButtonFactory {

    fun createButton(platform: PlatformType): Button {
        return when (platform) {
            PlatformType.WINDOWS -> WindowsButton()
            PlatformType.MAC  -> MacOSButton()
            else -> throw IllegalArgumentException("Invalid platform: $platform")
        }
    }
}

fun main() {
    val buttonFactory = ButtonFactory()

    val windowsButton = buttonFactory.createButton(PlatformType.MAC)
    windowsButton.display() // Output: Rendering a Windows style button.

    val macOSButton = buttonFactory.createButton(PlatformType.WINDOWS)
    macOSButton.display() // Output: Rendering a MacOS style button.
}
