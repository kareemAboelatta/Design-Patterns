package behavioral

abstract class Subject{
    private var  observers = ArrayList<Observer>()



    abstract  fun setState(state:String)
    abstract  fun getState(): String

    fun attach(observer: Observer){
        observers.add(observer)
    }

    fun detach(observer: Observer){
        observers.remove(observer)
    }

    fun notifyAllObservers(){
        observers.forEach {observer->
            observer.update()
        }
    }
}


abstract class Observer{
    lateinit var subject: Subject
    abstract fun update()
}



class ElliFeha : Subject(){
    private var state = "Silent"

    override fun setState(state: String) {
        this.state =state
        notifyAllObservers()
    }
    override fun getState(): String {
        return  state
    }

}



class Player(subject: Subject, val name: String) : Observer(){

    init {
        this.subject = subject
        subject.attach(this)
    }

    fun edrab(){
        subject.setState("aaah!")
    }

    override fun update() {
        println("$name heard ${subject.getState()}")
    }


}


fun main() {
    val youssef = ElliFeha()

    val kareem  = Player(name = "kareem" , subject = youssef)
    val nosa  = Player(name = "nosa" , subject = youssef)
    val mohamed  = Player(name = "mohamed" , subject = youssef)

    kareem.edrab()
    Thread.sleep(5000)


    nosa.edrab()
    Thread.sleep(5000)


    mohamed.edrab()
    Thread.sleep(5000)





}

/**
 * when we use
 *  -when having an object that's needs to be observed by one or more observers.
 *  -Decoupling observable and observer.
 *  -Used in MVC pattern.
 *
 * */


/**
 * '''Kotlin'''
 * PitFalls
 *  -Observable doesn't know which observer update its state
 *  -Large updates (take care in implementation)(state management )
 *  - Difficult Debugging
 *
 * */

//Design Patterns: Observer Pattern (Arabic)
//https://www.youtube.com/watch?v=R-N7YWJSol8&list=PLd-dOEgzBpGnt3GuEszo_piQq52XSqAmj&index=2
















