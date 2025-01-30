package _patterns.creational.factories.abstract_factory

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


enum class Platform{
    WINDOWS,MacOS
}
fun main() {
    val platform : Platform = Platform.WINDOWS // or "MacOS"

    val guiFactory = when (platform) {
        Platform.WINDOWS -> WindowsGUIFactory()
        Platform.MacOS -> MacOSGUIFactory()
    }

    val application = Application(guiFactory)
    application.renderUI()
}