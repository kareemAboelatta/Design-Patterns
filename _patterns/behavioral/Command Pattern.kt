package _patterns.behavioral



class  Receiver(private val id : Int){
    private var money= 0

    fun receiveMoney(money:Int){
        this.money += money
        println("Receiver $id Total money = ${this.money}")
    }
}



interface Command {
    fun execute()
}

class SendMoneyCommand(private  val receiver: Receiver) : Command{
    override fun execute() {
        receiver.receiveMoney(500)
    }
}

class SendMoneyToAllCommand(private  val listOfReceiver: List<Receiver>) : Command{
    override fun execute() {
        listOfReceiver.forEach {receiver ->
            receiver.receiveMoney(500)
        }
    }
}


class  Invoker{
    fun execute(command : Command){
        command.execute()
    }
}


//am Ahmed
fun main() {
    val osama = Invoker()

    val amAly = Receiver(0)

    val sendMoneyCommand = SendMoneyCommand(amAly)
    osama.execute(sendMoneyCommand)

    val amMohsen = Receiver(1)
    val amIbrahim = Receiver(2)


    val sendMoneyToAllCommand =SendMoneyToAllCommand(listOf(amAly,amMohsen,amIbrahim))
    osama.execute(sendMoneyToAllCommand)


}


/**
 * The Command Design Pattern is a _patterns.behavioral design pattern that encapsulates a request as an object, thereby allowing clients to parameterize different requests, queue or log requests, and support undoable operations.

In simpler terms, the Command Design Pattern provides a way to encapsulate a specific action or request in a separate object, which can be executed at a later time or even multiple times. This allows for more flexible and modular design, as the object can be created and executed without needing to know the specifics of the action being performed or the object that will execute it.

The _patterns.creational.main components of the Command Design Pattern are:

Command: defines an interface for executing an operation
Concrete Command: implements the Command interface and binds to a receiver object
Receiver: knows how to perform the operations associated with a request
Invoker: sends the command to the receiver to execute the request
Client: creates Concrete Command objects and sets its receiver
By using the Command Design Pattern, it becomes easier to add new commands or modify existing ones without having to change the code that uses the commands. Additionally, it provides a way to queue or log commands for later use, as well as supporting undo and redo operations.
 * */



/**
 * when we use
 *  -Encapsulating  a request in an object
 *  -Decouple sender from processor or receiver
 *  -Undo Operations
 *  -when we have too much functionality within a class
 * */

/**
 * PitFalls
 *  -usually used with combination with another pattern
 *  -high number of class to achieve required goal
 *  -Each command is an object and this does against object-oriented design (this command belong to another thing(object) but we can accept it])
 * */


//Design Patterns: Command Pattern (Arabic)
//https://www.youtube.com/watch?v=KZijJsBIFME&list=PLd-dOEgzBpGnt3GuEszo_piQq52XSqAmj&index=3









