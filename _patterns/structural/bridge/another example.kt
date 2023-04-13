package _patterns.structural.bridge

// Implementation
interface OS{
    fun doOperation()
}

class Windows : OS{
    override fun doOperation() {
        println("Doing operation on Windows Platform")
    }
}

class Mac : OS{
    override fun doOperation() {
        println("Doing operation on Mac Platform")
    }
}

class Linux : OS{
    override fun doOperation() {
        println("Doing operation on Linux Platform")
    }
}







// Abstraction
interface CommonUI{
    var os:OS // acts as the "bridge" between the abstraction and implementation,
    fun click()
}

// Refined Abstraction
class Button(override var os: OS) : CommonUI{
    override fun click() {
        os.doOperation()
    }
}








fun main() {

    // Client can create many different views without change abstraction or implementation
    val windows =Windows()
    val button1 = Button(windows)

    button1.click()





    val os =Mac()
    val button2 = Button(os)

    button2.click()



}
























