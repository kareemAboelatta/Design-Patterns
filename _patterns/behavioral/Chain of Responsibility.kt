package _patterns.behavioral



enum class RequestType{
    CONFERENCE, PURCHASE
}
data class Request(val requestType: RequestType ,val amount: Double )


abstract class Handler{
    internal var successor: Handler ? = null

    fun setSuccessor(successor: Handler){
        this.successor = successor
    }

    abstract fun handleRequest(request: Request)
}

class Director : Handler(){
    override fun handleRequest(request: Request) {
        if (request.requestType == RequestType.CONFERENCE){
            println("I can approve conference because I'm a Director")
        }else{
            successor?.handleRequest(request)
        }
    }

}

class VP : Handler(){
    override fun handleRequest(request: Request) {
        if ((request.requestType == RequestType.PURCHASE ) and (request.amount < 1500)){
            println("I can approve this a PURCHASE because I'm a VP and amount < 1500 ")
        }else{
            successor?.handleRequest(request)
        }
    }

}

class CEO : Handler(){
    override fun handleRequest(request: Request) {
            println("I can approve conference because I'm The CEO")
    }

}

fun main() {
    val radwa = Director()
    val nadeen = VP()
    val mostafa = CEO()

    radwa.setSuccessor(nadeen)
    nadeen.setSuccessor(mostafa)


    val request = Request(RequestType.PURCHASE,3500.0)
    radwa.handleRequest(request)

}


/***
 *
 * The Chain of Responsibility Design Pattern is a _patterns.behaviora design pattern that allows a request to be passed through a chain of objects, each potentially handling the request or passing it on to the next object in the chain.

In simpler terms, the Chain of Responsibility pattern provides a way to decouple the sender and receiver of a request by allowing multiple objects to handle the request without the sender having to know which object will handle it.

The main components of the Chain of Responsibility Design Pattern are:

Handler: defines an interface for handling requests and optionally provides a reference to the next handler in the chain
Concrete Handler: implements the Handler interface and handles requests it is responsible for, passing on other requests to the next handler in the chain
Client: creates and sends requests to the first handler in the chain

By using the Chain of Responsibility Design Pattern, we can create flexible and extensible systems that can easily be modified without having to modify the sender or any of the handlers. Additionally, it allows for multiple objects to handle requests without any explicit coupling between them.

One of the most common examples of the Chain of Responsibility pattern is the event propagation in the Document Object Model (DOM) of web browsers, where an event is first sent to the topmost element in the hierarchy and then propagated down the chain of nested elements until it is handled by a suitable event handler.

 * */

/**
 * PitFalls
 *  - Efficiency issues with long chains
 *  -No guarantee for request handling
 *
 * */

//Behavioral Design Patterns: Chain of Responsibility (Arabic)
// video link = https://www.youtube.com/watch?v=-UQND--CVew&list=PLd-dOEgzBpGnt3GuEszo_piQq52XSqAmj&index=1