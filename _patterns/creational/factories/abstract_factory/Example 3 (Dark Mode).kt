package _patterns.creational.factories.abstract_factory

interface TextButton {
    fun render()
}

interface TextField {
    fun type()
}

interface UIFactory {
    fun createButton(): TextButton
    fun createTextField(): TextField
}

class LightButton: TextButton {
    override fun render() {
        println("Render light button")
    }
}

class DarkButton: TextButton {
    override fun render() {
        println("Render dark button")
    }
}

class LightTextField: TextField {
    override fun type() {
        println("Type in a light text field")
    }
}

class DarkTextField: TextField {
    override fun type() {
        println("Type in a dark text field")
    }
}
// Concrete factory for a light theme
class LightUIFactory: UIFactory {
    override fun createButton(): TextButton = LightButton()
    override fun createTextField(): TextField = LightTextField()
}

// Concrete factory for a dark theme
class DarkUIFactory: UIFactory {
    override fun createButton(): TextButton = DarkButton()
    override fun createTextField(): TextField = DarkTextField()
}



fun main() {
    // Choose the fa`ctory
    val uiFactory: UIFactory = LightUIFactory()
    val button = uiFactory.createButton()
    val textField = uiFactory.createTextField()

    button.render()
    textField.type()
}
