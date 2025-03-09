package _patterns.behavioral

// 1) Define an Observer interface
interface Observer {
    fun update(data: String)
}

// 2) Define a Subject interface (the “observable”)
interface Subject {
    fun registerObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers()
}

// 3) A concrete Subject that holds data and notifies observers
class NewsPublisher : Subject {
    private val observers = mutableListOf<Observer>()
    private var latestNews: String = "No news yet"

    fun setNews(news: String) {
        latestNews = news
        notifyObservers()  // Whenever data changes, notify observers
    }

    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        observers.forEach { observer ->
            observer.update(latestNews)
        }
    }
}

// 4) Concrete Observer
class NewsReader(val name: String) : Observer {
    override fun update(data: String) {
        println("$name got the news update: $data")
    }
}

// 5) Usage
fun main() {
    val newsPublisher = NewsPublisher()

    val readerA = NewsReader("Reader A")
    val readerB = NewsReader("Reader B")
    val readerC = NewsReader("Reader C")

    // Register observers
    newsPublisher.registerObserver(readerA)
    newsPublisher.registerObserver(readerB)
    newsPublisher.registerObserver(readerC)

    // Publisher sets new data, automatically notifies observers
    newsPublisher.setNews("Breaking News: Kotlin is awesome!")
    newsPublisher.setNews("Breaking News: Kareem Loves his Wife")
}


/**
 * The Observer Design Pattern is a _patterns.behavioral design pattern that allows objects to be notified and updated when the state of another object changes.

In simpler terms, the Observer pattern provides a way to establish a one-to-many dependency between objects, so that when the state of one object changes, all its dependents are automatically notified and updated.

The _patterns.creational.main components of the Observer Design Pattern are:

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





/**
 * The Observer pattern defines a one-to-many relationship between objects: when one object changes state,
 * all its dependents are notified automatically. In Kotlin, you often see this behavior through
 * things like LiveData, where observers automatically receive updates when the underlying data changes.
 * */
val ObserverPattern = "ObserverPattern"









