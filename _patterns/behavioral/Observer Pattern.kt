package _patterns.behavioral

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
 * The Observer Design Pattern is a _patterns.behavioral design pattern that allows objects to be notified and updated when the state of another object changes.

In simpler terms, the Observer pattern provides a way to establish a one-to-many dependency between objects, so that when the state of one object changes, all its dependents are automatically notified and updated.

The main components of the Observer Design Pattern are:

Subject: maintains a list of observers and notifies them of any changes in its state
Observer: defines an interface for objects that should be notified of changes in the subject's state
Concrete Subject: implements the Subject interface and maintains the state of interest
Concrete Observer: implements the Observer interface and stores a reference to the Concrete Subject
By using the Observer Design Pattern, we can create loosely coupled systems that can be easily modified and extended. The pattern allows for a separation of concerns between objects that change and objects that need to be notified of those changes, making it easier to maintain and test the code. Additionally, it allows for the addition of new observers without having to modify the subject or other existing observers.

One of the most common examples of the Observer pattern is the Model-View-Controller (MVC) architecture, where the Model is the Subject and the View is the Observer. When the Model changes, the View is notified and updates its display accordingly.
 * */


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
















