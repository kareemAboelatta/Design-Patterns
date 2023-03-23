package behavioral



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
    var radwa = Director()
    var nadeen = VP()
    var mostafa = CEO()

    radwa.setSuccessor(nadeen)
    nadeen.setSuccessor(mostafa)


    var request = Request(RequestType.CONFERENCE,500.0)
    radwa.handleRequest(request)

}

