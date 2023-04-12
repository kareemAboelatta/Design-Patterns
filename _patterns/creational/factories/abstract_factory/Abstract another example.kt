
// Abstract Product interfaces
interface Button {
    fun display()
}

interface TextView {
    fun display()
}

// Concrete Product implementations for Android platform
class AndroidButton : Button {
    override fun display() {
        println("Rendering an Android style button.")
    }
}

class AndroidTextView : TextView {
    override fun display() {
        println("Rendering an Android style text view.")
    }
}

// Concrete Product implementations for iOS platform
class IOSButton : Button {
    override fun display() {
        println("Rendering an iOS style button.")
    }
}

class IOSTextView : TextView {
    override fun display() {
        println("Rendering an iOS style text view.")
    }
}

// Concrete Product implementations for Web platform
class WebButton : Button {
    override fun display() {
        println("Rendering a Web style button.")
    }
}

class WebTextView : TextView {
    override fun display() {
        println("Rendering a Web style text view.")
    }
}

// Abstract Factory interface
interface UIFactory {
    fun createButton(): Button
    fun createTextView(): TextView
}

// Concrete Factory implementations for different platforms
class AndroidUIFactory : UIFactory {
    override fun createButton(): Button {
        return AndroidButton()
    }

    override fun createTextView(): TextView {
        return AndroidTextView()
    }
}

class IOSUIFactory : UIFactory {
    override fun createButton(): Button {
        return IOSButton()
    }

    override fun createTextView(): TextView {
        return IOSTextView()
    }
}

class WebUIFactory : UIFactory {
    override fun createButton(): Button {
        return WebButton()
    }

    override fun createTextView(): TextView {
        return WebTextView()
    }
}




// Client code
fun main() {
    // Determine target platform dynamically (e.g., based on device type, user preference, etc.)
    val platform = "Web" // or "iOS", "Web"

    // Create UI elements using the appropriate factory based on the target platform
    val uiFactory: UIFactory = when (platform) {
        "Android" -> AndroidUIFactory()
        "iOS" -> IOSUIFactory()
        "Web" -> WebUIFactory()
        else -> throw IllegalArgumentException("Invalid platform: $platform")
    }

    // Use the created UI elements
    val button = uiFactory.createButton()
    val textView = uiFactory.createTextView()

    button.display()
    textView.display()
}
