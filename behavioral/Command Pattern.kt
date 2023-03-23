package behavioral


class  Receiver(private val id : Int){
    private var money= 0

    fun sendMoney(money:Int){
        this.money =money
        println("Receiver $id Total money = ${this.money}")
    }
}





interface Command {
    fun execute()
}

class SendMoneyCommand(private  val receiver: Receiver) : Command{
    override fun execute() {
        receiver.sendMoney(500)
    }
}

class SendMoneyToAllCommand(private  val listOfReceiver: List<Receiver>) : Command{
    override fun execute() {
        listOfReceiver.forEach {receiver ->
            receiver.sendMoney(500)
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









