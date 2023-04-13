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
    var os:OS
    fun click()
}

// Refined Abstraction
class Button(override var os: OS) : CommonUI{
    override fun click() {
        os.doOperation()
    }
}








fun main() {
    val os =Windows()
    val button = Button(os)


    button.click()



}
























